package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dao.UsersDAO;
import model.Users;

/**
 * Servlet implementation class AdminChangeRoleController
 */
@WebServlet("/AdminChangeRoleController")
public class AdminChangeRoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangeRoleController() {
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
		long id = Long.parseLong(request.getParameter("id"));
		UsersDAO dao= new UsersDAO();
				Users user=dao.getUsersById(id); // lấy user theo id
		try {
			dao.changeRole(user); // gọi phương thức changerole để update phân quyền user
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Users>	listU = dao.getListUsers();
		// Khởi tạo gson
		Gson  gson = new GsonBuilder().create();
		JsonArray jarray = gson.toJsonTree(listU).getAsJsonArray(); 
	    JsonObject jsonObject = new JsonObject(); 
	    jsonObject.add("products", jarray);
	    request.setAttribute("jsonUser", jarray);
			
		response.sendRedirect("AdminManagaUserController");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
