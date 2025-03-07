package surge;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the session and invalidate it to log out the user
        HttpSession session = request.getSession(false);  // Get the existing session if it exists
        if (session != null) {
            session.invalidate();  // Invalidate the session
        }

        // Redirect to the logout page
        response.sendRedirect("logout.html");
    }
}
