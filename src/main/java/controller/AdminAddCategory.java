package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.CategoryBO;
import model.Category;

/**
 * Servlet implementation class AdminAddCategory
 */
public class AdminAddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Category category = new Category();
		category.setNameCategory(request.getParameter("tenloai"));
		CategoryBO categoryControl = new CategoryBO();
		boolean check = categoryControl.addCategory(category); // kiểm tra người dùng có muốn thêm danh mục ko
		if(check==true) {
			HttpSession session = request.getSession();
			session.setAttribute("Add", "Success"); // gán dữ liệu cho session
			session.setMaxInactiveInterval(15); //Thiet lap khoang thoi gian cho session
			response.sendRedirect("AdminListCategory"); // Chuyen huong sang adminlistcategory
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminListCategory");
		dispatcher.forward(request, response);
		
		
	}

}
