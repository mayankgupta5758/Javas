import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HelloServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	System.out.println("Serer started..."); 
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // CORS fix (important for VS Code frontend)
        response.setHeader("Access-Control-Allow-Origin", "*");

        // Response type
        response.setContentType("text/plain");

        // Output
        response.getWriter().println("Hello bhai backend se ");
        System.out.println("Get req.");
    }
    
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    	System.out.println("Server Destroy...");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	System.out.println("FSDgsdsssssssssssssssssssssssssssssssssssssssssss");
        doGet(request, response);
        System.out.println("DDDSf");
    }
}