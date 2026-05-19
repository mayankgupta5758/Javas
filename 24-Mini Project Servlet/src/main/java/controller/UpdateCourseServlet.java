package controller;

import java.io.IOException;

import dao.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Course;
import model.Student;
import util.UtilityFunction;

@WebServlet("/updateCourse")
public class UpdateCourseServlet extends HttpServlet {

	private CourseDAO courseDAO = new CourseDAO();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String duration = (req.getParameter("duration"));
		double fees = Double.parseDouble(req.getParameter("fees"));
		String trainerName = req.getParameter("trainerName");

		if (fees <= 0) {
			Course course = courseDAO.getCourseById(id);
			req.setAttribute("course", course);
			req.getSession().setAttribute("updatcoursefailemsg", "Add Course Failed. Fees Must be +ve");
			req.getRequestDispatcher("/views/edit-course.jsp").forward(req, resp);
			return;
		}
		if (!UtilityFunction.isValidDuration(duration)) {
			Course course = courseDAO.getCourseById(id);
			req.setAttribute("course", course);
			req.getSession().setAttribute("updatcoursefailemsg", "Add Course Failed. Duration Must be +ve");
			req.getRequestDispatcher("/views/edit-course.jsp").forward(req, resp);
			return;
		}

		String chkDup = courseDAO.checkDuplicateCourseForUpdate(id, name, trainerName);
		if(chkDup != null) {
			Course course = courseDAO.getCourseById(id);
			req.setAttribute("course", course);
			req.getSession().setAttribute("updatcoursefailemsg", chkDup);
			req.getRequestDispatcher("/views/edit-course.jsp").forward(req, resp);
			return;
		}
		Course s = new Course(id, name, duration, fees, trainerName);

		CourseDAO dao = new CourseDAO();

		boolean status = dao.updateCourse(s);

		if (status) {
			req.getSession().setAttribute("updatecoursepassmsg", "Update Course Successfully.");
			resp.sendRedirect(req.getContextPath() + "/views/course-list.jsp");
			return;
		}
		req.getSession().setAttribute("updatcoursefailemsg", "Update Course Failed");
		resp.sendRedirect(req.getContextPath() + "/views/edit-course.jsp");
	}
}
