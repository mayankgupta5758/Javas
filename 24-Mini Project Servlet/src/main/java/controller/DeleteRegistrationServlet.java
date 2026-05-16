package controller;

import java.io.IOException;

import dao.RegistrationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/deleteRegistration")
public class DeleteRegistrationServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		RegistrationDAO dao = new RegistrationDAO();

		boolean status = dao.deleteRegistration(id);

		if (status) {
			req.getSession().setAttribute("deleteregemsg", "Registration Deleted Successfully");
		} else {
			req.getSession().setAttribute("deleteregmsg", "Failed To Delete Registration");
		}

		resp.sendRedirect(req.getContextPath() + "/views/registration-list.jsp");
	}
}
