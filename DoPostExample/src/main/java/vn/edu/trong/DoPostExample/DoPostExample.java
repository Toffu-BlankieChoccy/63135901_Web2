package vn.edu.trong.DoPostExample;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DoPostExample
 */
public class DoPostExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoPostExample() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setContentType("text/html");
    	response.setCharacterEncoding("utf-8");
    	PrintWriter returnValue = response.getWriter();
    	String htmlContent = "<form method=\"POST\" action=\"/DoPostExample/DoPostExample\">"
    	        + " <label> Họ:</label>"
    	        + "<input type=\"text\" name=\"fname\" > <br>\r\n"
    	        + " <label> Tên:</label>"
    	        + "<input type=\"text\" name=\"lname\" > <br>\r\n"
    	        + "<input type=\"submit\" value=\"Send\" >"
    	        + "</form>";

    	returnValue.append(htmlContent);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
    	response.setCharacterEncoding("utf-8");
    	String value1 = request.getParameter("fname");
    	String value2 = request.getParameter("lname");
    	PrintWriter returnValue = response.getWriter();
    	returnValue.append("First name: ");
    	returnValue.append(value1);
    	
    	returnValue.append("<br>Last name: ");
		returnValue.append(value2);
	}

}
