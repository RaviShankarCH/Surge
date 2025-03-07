package surge;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  private static final String USERNAME = "gaddamdivya75@gmail.com";
	    private static final String PASSWORD = "12345";

   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail=request.getParameter("email");
		String password=request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();



		if(USERNAME.equals(mail) && PASSWORD.equals(password)) {
                          out.println("successful login mail");
			System.out.println("successful login mail");
		}
		else {
                          out.println("Enter correct mail and password");
 			System.out.println("Enter correct mail and password");
                           

		}
		
	

	}
}