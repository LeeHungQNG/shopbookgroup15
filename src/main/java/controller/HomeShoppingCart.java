package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import bo.BookBO;
import bo.CartBO;
import model.Books;
import model.Cart;
import model.Item;
import model.Users;

/**
 * Servlet implementation class HomeShoppingCart
 */
@WebServlet("/HomeShoppingCart")
public class HomeShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session =request.getSession();
		Users user=(Users) session.getAttribute("uslogin");
		Map<Books, Integer> map = new HashMap<Books, Integer>();
		CartBO cartBO = new CartBO();
		BookBO bo = new BookBO();
		Cart cart =cartBO.getCartByIDU(user.getId());
		//GET SẢN PHAM  GIO Hag
		if(cart!=null) {
			List<Item> items =cartBO.getListItem(cart.getId());
			for(Item item :items) {
				Books books = bo.getBookByID(item.getIdBook());
				  map.put(books,item.getQuantity());
				  
			}
			session.setAttribute("shoppingcart", map);
			session.setAttribute("cart", cart);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("shoping-cart.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
