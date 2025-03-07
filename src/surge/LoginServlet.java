package surge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get username and password from request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Set response content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Check if the username and password match the correct credentials
        if ("admin".equals(username) && "admin".equals(password)) {
            out.println("<h1>Login Successful</h1>");
            System.out.println("Login successfully");
            response.sendRedirect("Dashboard.html");
        } else {
            out.println("<h1>Invalid Credentials</h1>");
            System.out.println("Invalid credentials");
        }
    }
}
