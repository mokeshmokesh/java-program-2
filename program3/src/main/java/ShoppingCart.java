

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		    String str1 = request.getParameter("item");  
	        String str2 = request.getParameter("qty");  
	        String str3 = request.getParameter("add"); 
	        String str4 = request.getParameter("list"); 
	       
	        response.setContentType("text/html");

	        PrintWriter out = response.getWriter();

	        if (str3 != null) {
	            
	            Cookie c1 = new Cookie(str1, str2);
	            response.addCookie(c1);  
	             
	            response.sendRedirect("ShoppingCart.html");
	        }
	        
	        else if (str4 != null) {
	            
	            Cookie[] clientCookies = request.getCookies();

	            if (clientCookies != null) {
	                
	                for (int i = 0; i < clientCookies.length; i++) {
	                    out.print("<B>" + clientCookies[i].getName() + " : " + clientCookies[i].getValue() + "</B><BR>");
	                }
	            } else {
	                out.print("No items in the cart.");
	            }
	        }

	      
	        out.close();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
