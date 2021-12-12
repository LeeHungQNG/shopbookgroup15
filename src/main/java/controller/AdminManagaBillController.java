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

import bo.BillsBO;
import dao.BillsDAO;
import model.Bills;

/**
 * Servlet implementation class AdminManagaOrderController
 */
@WebServlet("/AdminManagaBillController")
public class AdminManagaBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminManagaBillController() {
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
		BillsBO b = new BillsBO();
		List<Bills>	listB = b.getBills();
		// Khởi tạo Gson
		Gson  gson = new GsonBuilder().create();
		JsonArray jarray = gson.toJsonTree(listB).getAsJsonArray();//tạo json array
	    JsonObject jsonObject = new JsonObject();//tạo json array
	    jsonObject.add("products", jarray); // add product vào array

	    request.setAttribute("jsonBills", jarray);// request set vào để gửi đến view
	        
		RequestDispatcher rd = request.getRequestDispatcher("admin\\managabills.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
