package controller;

import java.io.IOException;

import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import util.UtilityFunction;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

	private StudentDAO studentDAO = new StudentDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		int age = Integer.parseInt(req.getParameter("age"));
		String city = req.getParameter("city");
		String email = req.getParameter("email");

		if (age <= 17) {
			req.getSession().setAttribute("addstdfailmsg", "Add Student Failed. Age must be 18+");
			resp.sendRedirect(req.getContextPath() + "/views/student-form.jsp");
			return;
		}
		if (phone.length() != 10) {
			req.getSession().setAttribute("addstdfailmsg", "Add Student Failed. Phone number must be 10 digit long");
			resp.sendRedirect(req.getContextPath() + "/views/student-form.jsp");
			return;
		}
		if (!UtilityFunction.isValidEmail(email)) {
			req.getSession().setAttribute("addstdfailmsg", "Add Student Failed. Enter valid email.");
			resp.sendRedirect(req.getContextPath() + "/views/student-form.jsp");
			return;
		}
		
		String chkDup = studentDAO.checkDuplicateStudent(name, email, phone);
		if(chkDup != null) {
			req.getSession().setAttribute("addstdfailmsg", chkDup);
			resp.sendRedirect(req.getContextPath() + "/views/student-form.jsp");
			return;
		}

		Student student = new Student(name, email, phone, age, city);

		boolean status = studentDAO.addStudent(student);
		if (status) {
			req.getSession().setAttribute("addstdpassmsg", "Student Added Successfully.");
			resp.sendRedirect(req.getContextPath() + "/views/student-list.jsp");
			return;
		}

		req.getSession().setAttribute("addstdfailmsg", "Add Student Failed");
		resp.sendRedirect(req.getContextPath() + "/views/student-form.jsp");
	}
}
