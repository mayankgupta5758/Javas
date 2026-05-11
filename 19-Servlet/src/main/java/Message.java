import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submit")
public class Message extends HttpServlet {

//	RequestDispacther0.
//	sendRedriect.

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String branch = req.getParameter("branch");

		/*
		 * req.setAttribute("name", name); req.setAttribute("age", age);
		 * req.setAttribute("branch", branch);
		 * 
		 * RequestDispatcher dispatcher =
		 * req.getRequestDispatcher("/RequestDispatcher1"); dispatcher.forward(req,
		 * resp); // ye kya krta hai ki user req1 bhejta hai servlet1 ko servlet1 //
		 * bhejta hai req1 ko servlet2 ke liya then servlet2 res1 send karega user ko.
		 * 
		 * dispatcher.include(req, resp); // ye kya krta hai ki user req1 bhejta hai
		 * servlet1 ko servlet1 // bhejta hai req1 ko servlet2 ke liya then servlet2
		 * res1 send karega servlet1 ko then servlet1 res1 // send karega user ko
		 */
	
		resp.sendRedirect(
			    req.getContextPath() + "/RequestDispatcher1?name=" + name + "&age=" + age + "&branch=" + branch
			);
	}
}
