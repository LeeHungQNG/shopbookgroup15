package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.BookBO;
import bo.BookDetailBO;
import bo.CategoryBO;
import model.BookDetail;
import model.Books;
import model.Category;

/**
 * Servlet implementation class HomeProductsDetail
 */
@WebServlet("/HomeProductsDetail")
public class HomeProductsDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeProductsDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		 long id = Long.parseLong(request.getParameter("id"));
		 	// LAY ID CUA SAN PHAM DO DE GUI TOI VIEW CHI TIET SAN PHAM 
			BookBO bookBO = new BookBO();
			BookDetailBO boDetailBO = new BookDetailBO();
			List<BookDetail> list= boDetailBO.getListBookDetails(id);
			Books product = bookBO.getBookByID(id);

			request.setAttribute("product", product);
			request.setAttribute("listDetails", list);

			// LAY DU LIEU CUA SAN PHAM GAN GIONG
			CategoryBO categoryControl = new CategoryBO();
			List<Category> listCategory = categoryControl.getListCategory();
			request.setAttribute("listCategory", listCategory);
			List<Books> lstallProduct= bookBO.getListBooks();
			request.setAttribute("listp", lstallProduct);


		RequestDispatcher dispatcher = request.getRequestDispatcher("product-details.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
