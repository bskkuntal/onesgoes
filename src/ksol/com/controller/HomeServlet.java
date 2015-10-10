package ksol.com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ksol.com.beans.Product;
import ksol.com.connection.SingletonDBConnection;
import ksol.com.dao.HomeDAO;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(urlPatterns = { "/home"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SingletonDBConnection dbSingletonConnection = SingletonDBConnection.getInstance();
	private HomeDAO homeDAO = new HomeDAO();
	private List<Product> listProducts = new ArrayList<Product>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		listProducts = homeDAO.getLatestProducts(dbSingletonConnection);
		request.setAttribute("LastestProducts", listProducts);
		// Forward sang /WEB-INF/views/productListView.jsp
	    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
