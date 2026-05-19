package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import dao.CourseDAO;
import dao.RegistrationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Course;
import model.Registration;

@WebServlet("/addRegistration")
public class AddRegistrationServlet extends HttpServlet {

	private RegistrationDAO registrationDAO = new RegistrationDAO();
	private CourseDAO courseDAO = new CourseDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int studentId = Integer.parseInt(req.getParameter("studentId"));
		int courseId = Integer.parseInt(req.getParameter("courseId"));
		Date registrationDate = Date.valueOf(req.getParameter("registrationDate"));
		String status = req.getParameter("status");

		Date currentDate = new Date(System.currentTimeMillis());

		if (registrationDate.after(currentDate)) {
			req.getSession().setAttribute("addregfailmsg", "Registration date cannot be future date.");
			resp.sendRedirect(req.getContextPath() + "/views/registration-form.jsp");
			return;
		}

		boolean chkAlrd = registrationDAO.alreadyRegistered(studentId, courseId, status);
		if (chkAlrd) {
			req.getSession().setAttribute("addregfailmsg", "Already Registered In This Course.");
			resp.sendRedirect(req.getContextPath() + "/views/registration-form.jsp");
			return;
		}

		Registration registration = new Registration(studentId, courseId, registrationDate, status);
		boolean result = registrationDAO.addRegistration(registration);

		if (result) {
			req.getSession().setAttribute("addregpassmsg", "Registration Added Successfully");
			resp.sendRedirect(req.getContextPath() + "/views/registration-list.jsp");
			return;
		}

		req.getSession().setAttribute("addregfailmsg", "Failed To Add Registration");
		resp.sendRedirect(req.getContextPath() + "/views/registration-form.jsp");
	}
}