import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/session2")
public class HttpSessionServlet2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		String name = (String)httpSession.getAttribute("k");
		
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("Name is : " + name);
	}
}
