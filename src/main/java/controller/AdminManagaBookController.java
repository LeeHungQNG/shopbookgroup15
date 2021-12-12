package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import bo.AuthorBO;
import bo.BookBO;
import bo.BookDetailBO;
import bo.CategoryBO;
import model.AuthorBook;
import model.BookDetail;
import model.Books;
import model.Category;

/**
 * Servlet implementation class AdminManagaProductController
 */
@WebServlet("/AdminManagaBookController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AdminManagaBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminManagaBookController() {
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
		BookBO bo = new BookBO();
		CategoryBO c = new CategoryBO();
		AuthorBO aubo = new AuthorBO();

		List<Books> listP = bo.getListBooks();
		List<AuthorBook> listAuthor = aubo.getListAuthor();
		List<Category> listC = c.getListCategory();

		request.setAttribute("listB", listAuthor);
		request.setAttribute("listC", listC);
		Gson gson = new GsonBuilder().create();
		JsonArray jarray = gson.toJsonTree(listP).getAsJsonArray();
		JsonArray jarrayAT = gson.toJsonTree(listAuthor).getAsJsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("products", jarray);
		request.setAttribute("jsonProducts", jarray);
		request.setAttribute("jsonAuthor", jarrayAT);


		RequestDispatcher rd = request.getRequestDispatcher("admin\\managaproduct.jsp");
		rd.forward(request, response);
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
		int sl=Integer.parseInt(amount);
		Date date=null;
	    try {
			 date=new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  

	    Books  books = new Books(1, IdC, booksname, dependency, null, price, dis, ida, 1,date, style, sl, address);				

		Part filePart = request.getPart("file");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString().trim();
		InputStream fileContent = filePart.getInputStream();
		long time=System.currentTimeMillis();

		String empty = new String();
		if (!fileName.equals(empty)) {
			String appPath = request.getServletContext().getRealPath("");
			appPath = appPath.replace('\\', '/');
			String fullSavePath = null;
			String name=time+fileName;
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
		books.setImageDisplay(time+fileName);
		dao.addBooks(books);
		response.sendRedirect("AdminManagaBookController");
	}
	

}
