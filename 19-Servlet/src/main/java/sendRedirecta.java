import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class sendRedirecta extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

//    	user req1 send karega servlet1 ko then servlet1 res1 ko send karega user ko or sath hi servlet2 ko bhi
//    	req2 send kar dega then servlet2 res2 send kar dega user ko res2.
        String user = req.getParameter("username");

        if(user.equals("admin")) {

            // redirect
            res.sendRedirect("dashboard.jsp");

        } else {
            res.sendRedirect("error.jsp");
        }
    }
}