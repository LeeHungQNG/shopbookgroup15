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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import bo.AuthorBO;
import dao.CategoryDAO;
import model.AuthorBook;
import model.Category;

/**
 * Servlet implementation class AdminMangageBrandController
 */
@WebServlet("/AdminMangageAuthorController")
public class AdminMangageAuthorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMangageAuthorController() {
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
		AuthorBO dao = new AuthorBO();
		List<AuthorBook>	listC = dao.getListAuthor();
		Gson  gson = new GsonBuilder().create();
		JsonArray jarray = gson.toJsonTree(listC).getAsJsonArray();
	    JsonObject jsonObject = new JsonObject();
	    jsonObject.add("products", jarray);
	    request.setAttribute("jsonBrand", jarray);
	        
		RequestDispatcher rd = request.getRequestDispatcher("admin\\manageauthor.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String author= request.getParameter("val-brand");
		String description =request.getParameter("val-description");
		AuthorBO dao = new AuthorBO();
		AuthorBook ca = new AuthorBook();
		ca.setNameAuthor(author);
		ca.setDescription(description);
		dao.addAuthor(ca);
		response.sendRedirect("AdminMangageAuthorController");
	}

}
