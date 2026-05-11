package controller;

import java.io.IOException;

import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDAO studentDAO = new StudentDAO();
		boolean status = studentDAO.deleteStudent(id);
		
		if(status) {
			resp.sendRedirect(req.getContextPath() + "/views/seeallstudent.jsp");
			return;
		} 
		req.setAttribute("deletestdmsg", "Delete Student Failed");	
		resp.sendRedirect(req.getContextPath() + "/views/seeallstudent.jsp");
	}
}
