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
 * Servlet implementation class AdminOrderCancelController
 */
@WebServlet("/AdminOrderCancelController")
public class AdminOrderCancelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOrderCancelController() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		BillsBO b = new BillsBO();
		List<Bills> listBD= b.getCancelOrder();
		 Gson  gson = new GsonBuilder().create();
		JsonArray jarrayB = gson.toJsonTree(listBD).getAsJsonArray();

	        JsonObject jsonObject = new JsonObject();
	        jsonObject.add("products", jarrayB);
	        request.setAttribute("jsonOrderCancel", jarrayB);
	        
		RequestDispatcher rd = request.getRequestDispatcher("admin\\managaordercancel.jsp");
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
