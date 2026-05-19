package controller;

import java.io.IOException;

import dao.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Course;
import util.UtilityFunction;

@WebServlet("/addCourse")
public class AddCourseServlet extends HttpServlet{

	private CourseDAO courseDAO = new CourseDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String duration = req.getParameter("duration");
		double fees = Double.parseDouble(req.getParameter("fees"));
		String trainerName = req.getParameter("trainerName");
		
		if(fees <= 0) {
			req.getSession().setAttribute("addcoursefaildmsg", "Add Course Failed. Fees Must be +ve");
			resp.sendRedirect(req.getContextPath() + "/views/course-form.jsp");
			return;
		}
		if(!UtilityFunction.isValidDuration(duration)) {
			req.getSession().setAttribute("addcoursefaildmsg", "Add Course Failed. Duration Must be +ve");
			resp.sendRedirect(req.getContextPath() + "/views/course-form.jsp");
			return;
		}
		
		String chkDup = courseDAO.checkDuplicateCourse(name, trainerName);
		if(chkDup != null) {
			req.getSession().setAttribute("addcoursefaildmsg", chkDup);
			resp.sendRedirect(req.getContextPath() + "/views/course-form.jsp");
			return;
		}
		
		Course course = new Course(name, duration, fees, trainerName);
		boolean status = courseDAO.addCourse(course);
		
		if(status) {
			req.getSession().setAttribute("addcoursepassmsg", "Course Added Successfully.");
			resp.sendRedirect(req.getContextPath() + "/views/course-list.jsp");
			return;
		} 
		
		req.getSession().setAttribute("addcoursefaildmsg", "Add Course Failed");
		resp.sendRedirect(req.getContextPath() + "/views/course-form.jsp");
	}
}
