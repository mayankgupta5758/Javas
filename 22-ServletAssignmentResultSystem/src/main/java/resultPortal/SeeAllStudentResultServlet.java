package resultPortal;

import java.io.IOException;
import Doa.StudentDoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/see")
public class SeeAllStudentResultServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StudentDoa doa = new StudentDoa();
		doa.showAllStudentResult(req, resp);
	}
}
