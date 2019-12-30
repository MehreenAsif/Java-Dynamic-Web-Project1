package ca.sheridancollege.controllers;

//Mehreen Asif Student ID 991539801
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
 * Servlet implementation class ViewCart
 */
@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//List<Product> productList = new CopyOnWriteArrayList<Product>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<Product> productList = (List<Product>)request.getSession().getAttribute("productList");
		
		response.setContentType("text/html");
	//for each loop for printing the price	
		for(Product product : productList)
		{
			System.out.println(product.getProductType()+ product.getProductPrice());
			
			response.getWriter().append
			("<h2 style=\"color: green; text-align:left;\">" + product.getProductType() + " has been added to your cart and the price is  $" + product.getProductPrice() +"</h1>");			
			
		}
	//link to go home or keep buying
		response.getWriter().append
		("<h2 style=\"color: green; text-align:left;\"><a href='Home.html'>Continue Shopping</a></h2>");
		response.getWriter().append
		("<form method='post' action='CheckOut'><input type='submit' value='Checkout'></form>");
		
	
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request dispatch to checkout
		request.getRequestDispatcher("CheckOut").forward(request, response);
		
		doGet(request, response);
	}

}
