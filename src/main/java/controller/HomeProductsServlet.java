package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.BookBO;
import bo.CategoryBO;
import model.Books;

/**
 * Servlet implementation class HomeProductsServlet
 */
public class HomeProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeProductsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		BookBO booksBo = new BookBO();
		CategoryBO c = new CategoryBO();
		
		String idLoaiSp = request.getParameter("id_category");
		String search = request.getParameter("search");
		String page = request.getParameter("page");
		String key = request.getParameter("key");
		List<Books> lstP = null;
		
		if (idLoaiSp != null) {
			lstP = booksBo.getListBookByIDC(Long.parseLong(idLoaiSp));
		}
		
		if (search != null) {
			lstP = booksBo.getBooksByName(key);
		}
	

		if (page != null) {
			int number = Integer.parseInt(page);
			lstP = booksBo.getBooksPage(number);
		}else if(idLoaiSp==null) {
			int number = 0;
			lstP = booksBo.getBooksPage(number);
		}
		
		List<Books> listbooks= booksBo.getListBooks();
		ArrayList<Integer> list = (ArrayList<Integer>) booksBo.getPage();

		request.setAttribute("page", list);
		request.setAttribute("lstProducts", listbooks);
		request.setAttribute("listbooks", lstP);
		request.setAttribute("lstCategory", c.getListCategory());
		
	
		RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");
		rd.forward(request, response);

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
