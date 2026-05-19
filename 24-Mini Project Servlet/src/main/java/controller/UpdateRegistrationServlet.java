package controller;

import java.io.IOException;
import java.sql.Date;

import dao.RegistrationDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Registration;

@WebServlet("/updateRegistration")
public class UpdateRegistrationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		int studentId = Integer.parseInt(req.getParameter("studentId"));
		int courseId = Integer.parseInt(req.getParameter("courseId"));
		Date registrationDate = Date.valueOf(req.getParameter("registrationDate"));
		String status = req.getParameter("status");

		Registration registration = new Registration(id, studentId, courseId, registrationDate, status);

		Date currentDate = new Date(System.currentTimeMillis());

		if (registrationDate.after(currentDate)) {
			req.getSession().setAttribute("updatregfailemsg", "Registration date cannot be future date.");
			req.setAttribute("registration", registration);

			RequestDispatcher rd = req.getRequestDispatcher("/views/edit-registration.jsp");
			rd.forward(req, resp);
			return;
		}

		RegistrationDAO dao = new RegistrationDAO();

		boolean alreadyExist = dao.alreadyRegisteredForUpdate(id, studentId, courseId);

		if (alreadyExist) {
			req.getSession().setAttribute("updatregfailemsg", "Student Already Registered In This Course.");
			req.setAttribute("registration", registration);
			RequestDispatcher rd = req.getRequestDispatcher("/views/edit-registration.jsp");
			rd.forward(req, resp);
			return;
		}

		boolean result = dao.updateRegistration(registration);

		if (result) {
			req.getSession().setAttribute("updateregpassmsg", "Student Update Successfully.");
			resp.sendRedirect(req.getContextPath() + "/views/registration-list.jsp");
			return;
		}

		req.getSession().setAttribute("updatregfailemsg", "Update Registration Failed");
		req.setAttribute("registration", registration);
		RequestDispatcher rd = req.getRequestDispatcher("/views/edit-registration.jsp");
		rd.forward(req, resp);
	}
}