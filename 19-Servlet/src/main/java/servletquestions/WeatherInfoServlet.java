package servletquestions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/weather")
public class WeatherInfoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		String cityName = req.getParameter("city");
		if(cityName.isEmpty() || cityName == null) {
			resp.sendRedirect(req.getContextPath() + "/weather.html");
			return;
		}
		Random rand = new Random();
		int randomInt2 = (int) (Math.random() * 101);
		
		printWriter.print("City weather is " + randomInt2);
		
	}
}
