package servletquestions;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/convert")
public class CurrencyConverterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double amount = Double.parseDouble(req.getParameter("amount"));
		String from = req.getParameter("from");
		String to = req.getParameter("to");
		
		if(amount <= 0) {
			resp.sendRedirect(req.getContextPath() + "/currency.html");
			return;
		}
		PrintWriter printWriter = resp.getWriter();
		printWriter.println(from + " -> " + to);
		printWriter.print("Your Amount is: ");
		printWriter.print(amount * 100);
	}
}
