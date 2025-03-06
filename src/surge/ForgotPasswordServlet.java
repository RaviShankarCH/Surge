package surge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Get the email from the form submission
        String email = request.getParameter("email");

        // Set response content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Simulate checking if the email exists in the system (here we simply check if email is not empty)
        if (email != null && !email.isEmpty()) {
            // Redirect the user to the Reset Password page
            response.sendRedirect("ResetPassword.html?email=" + email);  // Passing the email as a query string
        } else {
            out.println("<html><body>");
            out.println("<p>Error: Email is required.</p>");
            out.println("<p><a href='forgot-password.html'>Go back</a></p>");
            out.println("</body></html>");
        }
    }
}
