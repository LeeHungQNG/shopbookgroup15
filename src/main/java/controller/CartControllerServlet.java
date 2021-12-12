package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.BookBO;
import bo.CartBO;
import model.Books;
import model.Cart;
import model.Users;

/**
 * Servlet implementation class CartControllerServlet
 */
@WebServlet("/CartControllerServlet")
public class CartControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("uslogin");// đinh danh của user đăng nhập
		// get data từ view lên
		String key = request.getParameter("key");// định dành của nó key
		String id = request.getParameter("id");// định dành của nó id
		String amountS = request.getParameter("number-product");
		long idSP = Long.parseLong(id);

		BookBO bookBO = new BookBO();
		CartBO bo = new CartBO();// cần để láy datat lên

		Cart cart = bo.getCartByIDU(users.getId());
		//
		if (key != null && key.equals("remove")) {
			int amount = Integer.parseInt(amountS);
			int quantityS = bo.getListItemByID(cart.getId(), idSP);
			int math=quantityS-amount;
			if(amount==0) {
				bo.deleteProductByIDCart(idSP, cart.getId());	
			}else {
				bo.updateCartByIDCart(cart.getId(), idSP, amount);
			}
			Books books = bookBO.getBookByID(idSP);
			int ammount = cart.getAmount() - 1;
			double price = cart.getTotalPrice() - books.getPriceBook();
			cart.setAmount(ammount);
			cart.setTotalPrice(price);
			bo.updateCart(cart);
		} else {
			int amount = Integer.parseInt(amountS);
			int quantityS = bo.getListItemByID(cart.getId(), idSP);

			bo.updateCartByIDCart(cart.getId(), idSP, amount);
			Books books = bookBO.getBookByID(idSP);
			int amountUp = 0;
			double priceUp = 0;
			if (amount > quantityS) {
				amountUp = cart.getAmount() + amount - quantityS;
				priceUp = cart.getTotalPrice() + books.getPriceBook() * (amount - quantityS);
			} else {
				amountUp = cart.getAmount() -( quantityS - amount);
				priceUp = cart.getTotalPrice() - books.getPriceBook() * (quantityS - amount);
			}

			cart.setAmount(amountUp);
			cart.setTotalPrice(priceUp);
			bo.updateCart(cart);
		}

		// cập nhật lại các thông số khắc

		response.sendRedirect("HomeShoppingCart");
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
