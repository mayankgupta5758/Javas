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
		
		if (age <= 17) {
			Student student = studentDAO.getStudentById(id);
			req.setAttribute("student", student);
			req.getSession().setAttribute("updatestdfailmsg", "Update Failed. Age Must be 18+");
			req.getRequestDispatcher("/views/edit-student.jsp").forward(req, resp);
			return;
		}
		if (phone.length() != 10) {
			Student student = studentDAO.getStudentById(id);
			req.setAttribute("student", student);
			req.getSession().setAttribute("updatestdfailmsg", "Update Failed. Phone Number Must be if 10 Digit");
			req.getRequestDispatcher("/views/edit-student.jsp").forward(req, resp);
			return;
		}
		if (!UtilityFunction.isValidEmail(email)) {
			Student student = studentDAO.getStudentById(id);
			req.setAttribute("student", student);
			req.getSession().setAttribute("updatestdfailmsg", "Update Failed. Enter valid Email");
			req.getRequestDispatcher("/views/edit-student.jsp").forward(req, resp);
			return;
		}
		
		String chkDup = studentDAO.checkDuplicateStudentForUpdate(id, name, email, phone);
		
		if(chkDup != null) {
			Student student = studentDAO.getStudentById(id);
			req.setAttribute("student", student);
			req.getSession().setAttribute("updatestdfailmsg", chkDup);
			req.getRequestDispatcher("/views/edit-student.jsp").forward(req, resp);
			return;
		}

		Student s = new Student(id, name, email, phone, age, city);
		StudentDAO dao = new StudentDAO();

		boolean status = dao.updateStudent(s);
		if (status) {
			req.getSession().setAttribute("updatestdpassmsg", "Update Student Successfully.");
			resp.sendRedirect(req.getContextPath() + "/views/student-list.jsp");
			return;
		}
		req.getSession().setAttribute("uppdatestdfailmsg", "Update Student Failed");
		resp.sendRedirect(req.getContextPath() + "/views/edit-student.jsp");
	}
}
