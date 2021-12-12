package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bo.AuthorBO;
import bo.BookBO;
import bo.BookDetailBO;
import bo.CategoryBO;
import model.AuthorBook;
import model.Books;
import model.Category;

/**
 * Servlet implementation class AdminEditProductController
 */
@WebServlet("/AdminEditBookController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AdminEditBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminEditBookController() {
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
		String idx = request.getParameter("id");
		HttpSession session = request.getSession();
		long id = Long.parseLong(idx);
		CategoryBO c = new CategoryBO();
		AuthorBO authorBO = new AuthorBO();
		List<AuthorBook> listB = authorBO.getListAuthor();
		List<Category> listC = c.getListCategory();
		BookBO bo = new BookBO();
		Books p = bo.getBookByID(id);
		session.setAttribute("editproduct", p);
		request.setAttribute("listB", listB);
		request.setAttribute("listC", listC);
		request.setAttribute("bookedit", p);
		RequestDispatcher resd = request.getRequestDispatcher("admin\\editbook.jsp");
		resd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		BookBO dao = new BookBO();
		HttpSession session = request.getSession();
		Books bookS=(Books) session.getAttribute("editproduct");
		String booksname = request.getParameter("username");
		String style = request.getParameter("val-style");
		String author = request.getParameter("val-author");
		String address = request.getParameter("val-address");
		String status = request.getParameter("var-status");
		String dependency = request.getParameter("val-dependency");
		String category = request.getParameter("val-category");
		String current = request.getParameter("val-currency");
		String discount = request.getParameter("val-discount");
		String amount = request.getParameter("val-amount");
		String sdate = request.getParameter("val-sdate");
		long IdC = Long.parseLong(category);
		int ida = Integer.parseInt(author);
		int dis = Integer.parseInt(discount);
		double price = Double.parseDouble(current);
		int sl = Integer.parseInt(amount);
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		Books books = new Books(bookS.getId(), IdC, booksname, dependency, null, price, dis, ida, 1, date, style, sl, address);

		Part filePart = request.getPart("file");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString().trim();
		InputStream fileContent = filePart.getInputStream();
		long time = System.currentTimeMillis();
		String name="";
		String empty = new String();
		if (!fileName.equals(empty)) {
			String appPath = request.getServletContext().getRealPath("");
			appPath = appPath.replace('\\', '/');
			String fullSavePath = null;
			 name = time + fileName;
			if (appPath.endsWith("/")) {
				fullSavePath = appPath + "viewroot/img/shop/product/";
			} else {
				fullSavePath = appPath + "/" + "viewroot/img/shop/product/";
			}
			File file = new File(fullSavePath, name);
			try {
				Files.copy(fileContent, file.toPath());
			} catch (Exception e) {

			}
		}

		if (fileName == "") {
			books.setImageDisplay(bookS.getImageDisplay());
		} else {
			books.setImageDisplay(name);
		}
		dao.editBooks(books);
		response.sendRedirect("AdminEditBookController?id=" + bookS.getId());

	}

}
