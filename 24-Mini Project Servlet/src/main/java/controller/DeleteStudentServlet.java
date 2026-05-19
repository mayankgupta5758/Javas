package controller;

import java.io.IOException;

import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		StudentDAO studentDAO = new StudentDAO();

		String message = studentDAO.deleteStudent(id);
		if (message.equals("Student Deleted Successfully")) {
			req.getSession().setAttribute("deletestdpassmsg", message);
		} else {
			req.getSession().setAttribute("deletestdfailmsg", message);
		}
		resp.sendRedirect(req.getContextPath() + "/views/student-list.jsp");
	}
}