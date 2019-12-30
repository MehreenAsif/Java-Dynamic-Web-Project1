package ca.sheridancollege.controllers;
////Mehreen Asif Student ID 991539801
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.beans.Product;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//Message displayed when checking out
		
		response.setContentType("text/html");
		
		response.getWriter().append("<h3 style=\"color: green; text-align:left;\">Checking Out</h3>");
		
		//Retrieving the list
		
		List<Product> productList = (List<Product>)request.getSession().getAttribute("productList");
		
		//Initializing total price for all the products
		
		double totalProductPrice = 0;
		
		//for loop to add prices together and get total price
		
		
		
		for(Product product : productList) {
			totalProductPrice += product.getProductPrice();
		}
		//Show total price for all items with a link to either checkout or continue Shopping
		response.getWriter().append("<h2 style=\"color: green; text-align:left;\" > Your total bill is $" + totalProductPrice + "</h2>");
		response.getWriter().append("<a href='Home.html'>Go Back to Home Page</a>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
