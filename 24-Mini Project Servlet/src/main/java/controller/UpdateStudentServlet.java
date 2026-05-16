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

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

	private StudentDAO studentDAO = new StudentDAO();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		int age = Integer.parseInt(req.getParameter("age"));
		String phone = (req.getParameter("phone"));
		String city = req.getParameter("city");

		if (age <= 17 || phone.length() != 10 || !UtilityFunction.isValidEmail(email)) {
			Student student = studentDAO.getStudentById(id);
			req.setAttribute("student", student);
			req.setAttribute("updatemsg", "Update Failed. Something went Wrong");
			req.getRequestDispatcher("/views/edit-student.jsp").forward(req, resp);
			return;
		}

		Student s = new Student(id, name, email, phone, age, city);

		StudentDAO dao = new StudentDAO();

		boolean status = dao.updateStudent(s);

		if (status) {
			resp.sendRedirect(req.getContextPath() + "/views/student-list.jsp");
			return;
		}
		req.setAttribute("uppdatemsg", "Update Student Failed");
		resp.sendRedirect(req.getContextPath() + "/views/edit-student.jsp");
	}
}
