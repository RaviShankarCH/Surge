package surge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Get email, new password, and confirm password from the form submission
        String email = request.getParameter("email");
        String newPassword = request.getParameter("new-password");
        String confirmPassword = request.getParameter("confirm-password");

        // Set response content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Password Reset Status</h2>");

        // Check if new password and confirm password match
        if (newPassword != null && confirmPassword != null && newPassword.equals(confirmPassword)) {
            // Update the password in the database (simulated here)
            // In a real application, you would query the database and update the user's password
            out.println("<p>Your password has been successfully updated for email: " + email + "</p>");
            out.println("<p>Proceed to <a href='Email.html'>Login</a></p>");
        } else {
            out.println("<p>Error: Passwords do not match.</p>");
            out.println("<p>Please <a href='ResetPassword.html'>try again</a>.</p>");
        }

        out.println("</body></html>");
    }
}
