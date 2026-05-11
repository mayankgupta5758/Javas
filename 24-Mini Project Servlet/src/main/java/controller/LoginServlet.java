package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.AdminDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		AdminDAO adminDAO = new AdminDAO();
		
		List<String> list = adminDAO.getAdminCredentials();
		
		if(userName.equals(list.get(0)) && password.equals(list.get(1))) {
			HttpSession httpSession = req.getSession();
			Cookie cookie = new Cookie("userName", userName);
			cookie.setMaxAge(3600);
			
			httpSession.setAttribute("userName", userName);
			
			resp.sendRedirect(req.getContextPath() + "/views/dashboard.jsp");
			
		} else {
			req.setAttribute("adminmsg", "Admin Login Failed!!!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
