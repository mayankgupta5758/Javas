import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class ServletContext2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        ServletContext context = getServletContext();

        String company = (String) context.getAttribute("company");

        res.getWriter().println("Company: " + company);
    }
}