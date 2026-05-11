
public class Into {

	/*
	 * Introduction to Servlets
	 * 1. Servlets are Java programs that run on a web
	 * server, handling client requests and generating dynamic responses. 
	 * 2. Servlet used to process or store data submitted by an HTML form, provide dynamic
	 * content like returning results from a database query, manage state
	 * information, etc.
	 * 
	 * Servlet Lifecycle
	 * The lifecycle of a servlet is controlled by the container (e.g., Tomcat), and
	 * it goes through the following stages:Java development bootcamps
	 * 
	 * 1. Loading and Instantiation: The servlet class is loaded and an instance is created. 
	 * 2. Initialization (init method): The init method is called once to initialize the servlet. 
	 * 3. Request Handling (service method): The service \method is called for each request to process it. 
	 * 4. Destruction (destroy method): The destroy method is called once before the servlet is removed from
	 * service.
	 * 
	 * 1. User logs in

2. Server creates HttpSession

3. Server generates session ID

4. Server sends session ID to browser as JSESSIONID cookie

5. Browser sends JSESSIONID cookie with next request

6. Server reads JSESSIONID from HttpServletRequest

7. Server finds the matching HttpSession

8. Servlet can access session data
 
HttpServletRequest is a child of ServletRequest.

HttpServletRequest can access HttpSession.

ServletRequest cannot directly access HttpSession.
 
ServletRequest does not know sessions directly.
 
HttpServletRequest knows sessions because sessions are HTTP-specific.
 
HttpSession is reached through HttpServletRequest.
 
	 */
}
