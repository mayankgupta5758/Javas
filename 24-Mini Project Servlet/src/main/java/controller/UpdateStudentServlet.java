package controller;

import java.io.IOException;

import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		int age = Integer.parseInt(req.getParameter("age"));
		String phone = (req.getParameter("phone"));
		String city = req.getParameter("city");

		Student s = new Student(id, name, email, phone, age, city);

		StudentDAO dao = new StudentDAO();

		boolean status = dao.updateStudent(s);
		
		if(status) {
			resp.sendRedirect(req.getContextPath() + "/views/seeallstudent.jsp");
			return;
		} 
		req.setAttribute("uppdatemsg", "Update Student Failed");	
		resp.sendRedirect(req.getContextPath() + "/views/edit-student.jsp");
	}
}
