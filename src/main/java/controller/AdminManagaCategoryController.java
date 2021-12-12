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

import bo.CategoryBO;
import dao.CategoryDAO;
import dao.UsersDAO;
import model.Category;
import model.Users;

/**
 * Servlet implementation class AdminManagaCategoryController
 */
@WebServlet("/AdminManagaCategoryController")
public class AdminManagaCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminManagaCategoryController() {
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
		CategoryBO dao = new CategoryBO();
		List<Category>	listC = dao.getListCategory();
		Gson  gson = new GsonBuilder().create();
		JsonArray jarray = gson.toJsonTree(listC).getAsJsonArray();
	    JsonObject jsonObject = new JsonObject();
	    jsonObject.add("products", jarray);
	    request.setAttribute("jsonCategory", jarray);
	        
		RequestDispatcher rd = request.getRequestDispatcher("admin\\managecategory.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String category= request.getParameter("val-category");
		CategoryDAO dao = new CategoryDAO();
		Category ca = new Category();
		ca.setNameCategory(category);
		dao.addCategory(ca);
		response.sendRedirect("AdminManagaCategoryController");
	}

}
