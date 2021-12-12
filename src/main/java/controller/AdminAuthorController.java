package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AuthorBO;
import bo.CategoryBO;

/**
 * Servlet implementation class AdminAuthorController
 */
@WebServlet("/AdminAuthorController")
public class AdminAuthorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAuthorController() {
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
		long id = Long.parseLong(request.getParameter("id")); // lấy dữ liệu từ view lấy id
		AuthorBO authorBO = new AuthorBO();
		authorBO.deleteAuthor(id); // gọi phương thức delete trong authorBO để xóa
		response.sendRedirect("AdminMangageAuthorController"); // chuyển hướng sang AdminMangageAuthorController
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
