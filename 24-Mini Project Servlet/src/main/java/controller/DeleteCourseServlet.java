package controller;

import java.io.IOException;

import dao.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCourse")
public class DeleteCourseServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		CourseDAO dao = new CourseDAO();
		String msg = dao.deleteCourse(id);

		req.getSession().setAttribute("deletecoursepassmsg", msg);
		resp.sendRedirect(req.getContextPath() + "/views/course-list.jsp");
	}
}