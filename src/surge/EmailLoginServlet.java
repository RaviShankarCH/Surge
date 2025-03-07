package surge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmailLoginServlet")
public class EmailLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    // This would be a simple hardcoded validation, you can replace it with DB checks or any service later.
    private static final String VALID_EMAIL = "Ravi@gmail.com";
    private static final String VALID_PASSWORD = "Ravi123";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Get email and password from the request parameters
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Set the response content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Check if the email and password match the correct credentials
        if (VALID_EMAIL.equals(email) && VALID_PASSWORD.equals(password)) {
            out.println("<h1>Login Successful</h1>");
            System.out.println("Login successfully for user: " + email);
            response.sendRedirect("Dashboard.html"); 
        } else {
            out.println("<h1>Invalid Credentials</h1>");
            System.out.println("Invalid login attempt for user: " + email);
        }
    }
}
