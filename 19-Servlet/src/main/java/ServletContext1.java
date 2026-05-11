import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class ServletContext1 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        ServletContext context = getServletContext();

        // global data set
        context.setAttribute("company", "Infosys");

        res.getWriter().println("Data Stored");
    }
}