package controller;

import java.io.IOException;
import java.util.List;

import dao.RegistrationDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Registration;

@WebServlet("/filterRegistration")
public class FilterRegistrationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp)
			throws ServletException, IOException {

		String studentId = req.getParameter("studentId");

		String courseId = req.getParameter("courseId");

		String status = req.getParameter("status");

		RegistrationDAO dao = new RegistrationDAO();

		List<Registration> list =
				dao.filterRegistration(
						studentId,
						courseId,
						status
				);

		req.setAttribute("list", list);

		RequestDispatcher rd =
			req.getRequestDispatcher(
				"views/registration-list.jsp"
			);

		rd.forward(req, resp);
	}
}