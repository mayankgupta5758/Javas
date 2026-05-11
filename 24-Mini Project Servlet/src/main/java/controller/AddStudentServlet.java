package controller;

import java.io.IOException;

import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;


@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet{
	
	private StudentDAO studentDAO = new StudentDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		int age = Integer.parseInt(req.getParameter("age"));
		String city = req.getParameter("city");
		String email = req.getParameter("email");
		
		Student student = new Student(name, email, phone, age, city);
		
		boolean status = studentDAO.addStudent(student);
		
		if(status) {
			resp.sendRedirect(req.getContextPath() + "/views/seeallstudent.jsp");
			return;
		} 
		
		req.getSession().setAttribute("addstdmsg", "Add Student Failed");
		resp.sendRedirect(req.getContextPath() + "/views/student-form.jsp");
	}
}
