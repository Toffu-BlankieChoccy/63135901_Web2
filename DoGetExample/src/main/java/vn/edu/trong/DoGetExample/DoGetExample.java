package vn.edu.trong.DoGetExample;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DoGetExample
 */
public class DoGetExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoGetExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String value1 = request.getParameter("pr1");
		String value2 = request.getParameter("pr2");
		PrintWriter returnValue = response.getWriter();
		
		returnValue.append("Value 1: ");
		returnValue.append(value1);
		
		returnValue.append("\nValue 2: ");
		returnValue.append(value2);

	}

}
