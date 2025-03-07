package surge;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles form submissions and shows appropriate messages
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Check if the action is logout
        if ("logout".equals(action)) {
            // Invalidate the session and redirect to the login page
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate(); // Invalidate the session
            }
            response.sendRedirect("Email.html"); // Redirect to login page after logout
            return;
        }

        // If action is other than logout, process form data
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("address".equals(action)) {
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String country = request.getParameter("country");

            out.println("<html><body>");
            out.println("<h2>Address Details Submitted Successfully</h2>");
            out.println("<p><strong>City:</strong> " + city + "</p>");
            out.println("<p><strong>State:</strong> " + state + "</p>");
            out.println("<p><strong>Country:</strong> " + country + "</p>");
            out.println("<a href='Dashboard.html'>Back to Dashboard</a>");
            out.println("</body></html>");
        } else if ("education".equals(action)) {
            String qualification = request.getParameter("qualification");
            String passoutYear = request.getParameter("passout-year");
            String percentage = request.getParameter("percentage");

            out.println("<html><body>");
            out.println("<h2>Education Details Submitted Successfully</h2>");
            out.println("<p><strong>Highest Qualification:</strong> " + qualification + "</p>");
            out.println("<p><strong>Passout Year:</strong> " + passoutYear + "</p>");
            out.println("<p><strong>Percentage:</strong> " + percentage + "</p>");
            out.println("<a href='Dashboard.html'>Back to Dashboard</a>");
            out.println("</body></html>");
        } else if ("family".equals(action)) {
            String fatherName = request.getParameter("father-name");
            String motherName = request.getParameter("mother-name");
            String siblings = request.getParameter("siblings");

            out.println("<html><body>");
            out.println("<h2>Family Details Submitted Successfully</h2>");
            out.println("<p><strong>Father's Name:</strong> " + fatherName + "</p>");
            out.println("<p><strong>Mother's Name:</strong> " + motherName + "</p>");
            out.println("<p><strong>Number of Siblings:</strong> " + siblings + "</p>");
            out.println("<a href='Dashboard.html'>Back to Dashboard</a>");
            out.println("</body></html>");
        }
    }
}
