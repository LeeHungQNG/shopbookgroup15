package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.BookDetailBO;


/**
 * Servlet implementation class AdminDeleteProductDetail
 */
@WebServlet("/AdminDeleteBookDetail")
public class AdminDeleteBookDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminDeleteBookDetail() {
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
		// khởi tạo session
		HttpSession session =request.getSession();
		//lấy dữ liệu từ view
		long id = Long.parseLong(request.getParameter("id"));
		Long id_book = (Long) session.getAttribute("idP");
		// gọi phương thức delete để xóa book theo id
		BookDetailBO dao = new BookDetailBO();
		dao.deleteBookDetailByID(id);
		String url="AdminBookDetailsController?id="+id_book;
		response.sendRedirect(url);
	
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
