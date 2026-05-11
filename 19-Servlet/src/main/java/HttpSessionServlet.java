import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sessions")
public class HttpSessionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String n1 = req.getParameter("num1");
		HttpSession httpSession = req.getSession();

		httpSession.setAttribute("k", n1);
		resp.sendRedirect(req.getContextPath() + "/session2");
	}
//	| Feature     | request.setAttribute() | HttpSession         |
//	| ----------- | ---------------------- | ------------------- |
//	| Scope       | 1 request              | multiple requests   |
//	| Lifetime    | short (temporary)      | long (session tak)  |
//	| Use         | forward ke liye        | login, user data    |
//	| Memory      | kam use karta hai      | zyada use karta hai |
//	| Redirect me | lost ho jata hai       | safe rehta hai  |

}
