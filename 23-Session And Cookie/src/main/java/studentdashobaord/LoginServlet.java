package studentdashobaord;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("email");
		String password = req.getParameter("password");
		
		if(username.equals("admin") && password.equals("1234")) {
			HttpSession httpSession = req.getSession();
			
			httpSession.setAttribute("user", username);
			
			resp.sendRedirect(req.getContextPath() + "/dashboard.jsp");
			
		} else {
			resp.getWriter().println("Invalid credentials");
		}
	}
}
