package controller;

import java.io.IOException;

import dao.StudentDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        StudentDAO dao = new StudentDAO();
        Student student = dao.getStudentById(id);
        
        req.setAttribute("student", student);
        RequestDispatcher rd = req.getRequestDispatcher("views/edit-student.jsp");
        rd.forward(req, resp);
    }
}