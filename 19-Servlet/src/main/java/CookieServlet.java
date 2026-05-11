import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/message")
public class CookieServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		String n1 = req.getParameter("num1");
		boolean userVisit = false;
		Cookie[] cookie2 = req.getCookies();
		
		if(cookie2 != null) {
			for(int i=0;i<cookie2.length;i++) {
				Cookie c = cookie2[i];
				String key = c.getName();
				String val = c.getValue();
				
				if(key.equals("k") && val.equals("123")) {
					printWriter.print("Welcome back...  " + n1);
					userVisit = true;
					break;
				}
			}
		}
		if(userVisit == false) {
			Cookie cookie = new Cookie("k", "123");
			resp.addCookie(cookie);
			printWriter.print("Welcome " + n1);
		}
	}
}
