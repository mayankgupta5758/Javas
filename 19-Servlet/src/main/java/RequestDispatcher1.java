import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/RequestDispatcher1")
public class RequestDispatcher1 extends HttpServlet {

//	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//	same for this
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		/*
		 * res.setContentType("text/html");
		 * 
		 * String name = (String) req.getAttribute("name"); int age = (int)
		 * req.getAttribute("age"); String branch = (String) req.getAttribute("branch");
		 * 
		 * PrintWriter printWriter = res.getWriter(); printWriter.println("Name: " +
		 * name); printWriter.println("Age: " + age); printWriter.println("Branch: " +
		 * branch);
		 */

//    	ye hum bhej nahi reha fir bhi aa rahe hai mtlb vo url se hi le raha hai in ko.
//		called url re-writing
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String branch = req.getParameter("branch");

		PrintWriter printWriter = res.getWriter();
		printWriter.println("Name: " + name);
		printWriter.println("Age: " + age);
		printWriter.println("Branch: " + branch);
	}
}