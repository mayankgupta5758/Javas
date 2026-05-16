package controller;

import java.io.IOException;

import dao.RegistrationDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Registration;

@WebServlet("/editRegistration")
public class EditRegistrationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		
		RegistrationDAO dao = new RegistrationDAO();
		Registration registration = dao.getRegistrationById(id);
		req.setAttribute("registration", registration);
		
		RequestDispatcher rd = req.getRequestDispatcher("views/edit-registration.jsp");
		rd.forward(req, resp);
	}
}