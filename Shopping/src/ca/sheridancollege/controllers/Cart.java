package ca.sheridancollege.controllers;

//Mehreen Asif Student ID 991539801
//imports for the program to run
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.sheridancollege.beans.Product;


/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Product> productList = new CopyOnWriteArrayList<Product>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Setting session attribute
		request.getSession().setAttribute("productList", productList);
		
		//Redirecting response to ViewCart Servlet
		response.sendRedirect("ViewCart");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//attribute in session 
			String productType = request.getParameter("productType");
			HttpSession session = request.getSession();
			session.setAttribute("productType", productType);
		//initializing the initial price for each product
			double productPrice = 0.0;
		//if statements to assign the price for each product
			if (productType.contentEquals("bag"))
			{
				productPrice = 200.0;
			}
			else if (productType.contentEquals("shirt"))
			{
				productPrice = 35.0;
			}
			else if (productType.contentEquals("belt"))
			{
				productPrice = 40.0;
			}
			else if (productType.contentEquals("dress"))
			{
				productPrice = 150.0;
			}
			else if (productType.contentEquals("earphone"))
			{
				productPrice = 45.0;
			}
			else if (productType.contentEquals("shoes"))
			{
				productPrice = 100.0;
			}
			else if (productType.contentEquals("laptop"))
			{
				productPrice = 700.0;
			}
			else if (productType.contentEquals("travelmug"))
			{
				productPrice = 45.0;
			}
			else if (productType.contentEquals("tv"))
			{
				productPrice = 800.0;
			}
			else if (productType.contentEquals("phone"))
			{
				productPrice = 500.0;
			}
			else {
				response.getWriter().append("<h2>Please choose a product</h2>");
			}
		//Creating a product object and adding project object to the productlist
			Product product = new Product(productType, productPrice);
			
		
			productList.add(product);
							
		
		doGet(request, response);
	}

	
}
