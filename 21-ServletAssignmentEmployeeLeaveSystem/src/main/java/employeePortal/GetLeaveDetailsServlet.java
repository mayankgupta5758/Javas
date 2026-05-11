package employeePortal;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/click")
public class GetLeaveDetailsServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int id = Integer.parseInt(req.getParameter("id"));
		String dept = req.getParameter("dept");
		int numberOfDays = Integer.parseInt(req.getParameter("days"));
		String leaveType = req.getParameter("leave");
		String reason = req.getParameter("reason");
		
		if(reason.length() <= 10 || numberOfDays < 0 || id < 0 ) {
			resp.sendRedirect(req.getContextPath() + "/leaveForm.html");
			return;
		}
		
		req.setAttribute("name", name);
		req.setAttribute("id", id);
		req.setAttribute("dept", dept);
		req.setAttribute("days", numberOfDays);
		req.setAttribute("leave", leaveType);
		req.setAttribute("reason", reason);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/printLeaveDetails.jsp");
		dispatcher.forward(req, resp);
	}
}
