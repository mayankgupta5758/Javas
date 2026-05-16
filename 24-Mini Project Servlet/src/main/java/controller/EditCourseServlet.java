package controller;

import java.io.IOException;

import dao.CourseDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Course;


@WebServlet("/editCourse")
public class EditCourseServlet  extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        CourseDAO dao = new CourseDAO();
        Course course = dao.getCourseById(id);
        
        req.setAttribute("course", course);
        RequestDispatcher rd = req.getRequestDispatcher("views/edit-course.jsp");
        rd.forward(req, resp);
    }
}
