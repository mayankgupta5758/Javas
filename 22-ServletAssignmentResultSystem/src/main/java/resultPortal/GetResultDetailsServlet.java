package resultPortal;

import java.io.IOException;
import Doa.StudentDoa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/click")
public class GetResultDetailsServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int roll = Integer.parseInt(req.getParameter("roll"));
		int marks1 = Integer.parseInt(req.getParameter("sub1"));
		int marks2 = Integer.parseInt(req.getParameter("sub2"));
		int marks3 = Integer.parseInt(req.getParameter("sub3"));
		
		if(roll <= 0 || marks1 < 0 || marks2 < 0 || marks3 < 0 || marks1 > 100 || marks2 > 100 || marks3 > 100) {
			resp.sendRedirect(req.getContextPath() + "/resultForm.html");
			return;
		}
		
		Student student = new Student(name, roll, marks1, marks2, marks3);
		StudentDoa doa = new StudentDoa();
		doa.addStudent(student);
		
		
		req.setAttribute("name", name);
		req.setAttribute("roll", roll);
		req.setAttribute("sub1", marks1);
		req.setAttribute("sub2", marks2);
		req.setAttribute("sub3", marks3);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/printResult.jsp");
		dispatcher.forward(req, resp);
		
	}
}
