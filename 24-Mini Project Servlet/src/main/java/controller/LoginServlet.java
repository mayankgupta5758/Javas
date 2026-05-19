package controller;

import java.io.IOException;
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

		String remember = req.getParameter("remember");
		AdminDAO adminDAO = new AdminDAO();

		List<String> list = adminDAO.getAdminCredentials();

		if (userName.equals(list.get(0)) && password.equals(list.get(1))) {
			HttpSession session = req.getSession();
			session.setAttribute("userName", userName);

			if (remember != null) {
				Cookie cookie = new Cookie("rememberUser", userName);
				cookie.setMaxAge(60 * 60);
				resp.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("rememberUser", "");
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
			req.getSession().setAttribute("adminpassmsg", "LoggedIn Successfully.");
			resp.sendRedirect(req.getContextPath() + "/views/dashboard.jsp");
		} else {
			req.getSession().setAttribute("adminfailmsg", "Admin Login Failed!!!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		}
	}
}