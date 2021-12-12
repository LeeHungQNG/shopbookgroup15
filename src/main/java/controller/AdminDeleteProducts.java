package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.BookBO;
import model.Books;

/**
 * Servlet implementation class AdminDeleteProducts
 */
public class AdminDeleteProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BookBO bo= new BookBO();
		Books books = bo.getBookByID(id);
		
		String appPath = request.getServletContext().getRealPath("");
		appPath = appPath.replace('\\', '/');
		String fullSavePath = null;
		if (appPath.endsWith("/")) {
			fullSavePath = appPath + "assets/img/shop/product/";
		} else {
			fullSavePath = appPath + "/" + "assets/img/shop/product/";
		}

		String fileName = books.getImageDisplay();

		File file = new File(fullSavePath, fileName);
		System.out.println(file.getPath()+"1");

		boolean check = bo.deleteBooks(id);
		if (check) {
			HttpSession session = request.getSession();
			session.setAttribute("Delete", "Success");
			session.setMaxInactiveInterval(15);
			if (file.delete()) {
				System.out.println("Xóa file: " + file.getName());
			} else {
				System.out.println("Xóa file");
			}
			response.sendRedirect("AdminManagaProductController");
		} else {

		}

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
