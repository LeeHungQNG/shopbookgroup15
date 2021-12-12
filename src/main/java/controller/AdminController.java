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
import javax.swing.text.SimpleAttributeSet;

import org.apache.catalina.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import bo.BillsBO;
import bo.BookBO;
import bo.DashbroadBO;
import bo.UsersBO;
import dao.BillsDAO;
import dao.UsersDAO;
import model.Bills;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		BookBO bo = new BookBO();
		BillsBO billBo= new BillsBO();
		UsersBO usersBO = new UsersBO();
		double revenue=billBo.getSumBills();
		int trans=billBo.getTranspost().size();
		int amountP=bo.getListBooks().size();
		int amountU=usersBO.getListUsers().size();
		double doanhthu = 0;
		request.setAttribute("doanhthu", doanhthu);
		request.setAttribute("revenue", revenue);
		request.setAttribute("trans", trans);
		request.setAttribute("amountP", amountP);
		request.setAttribute("amountU", amountU);
		RequestDispatcher rd = request.getRequestDispatcher("admin\\dashboard.jsp");
		rd.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String sdate=request.getParameter("sdate");
		String enddate=request.getParameter("enddate");
		List<Bills> list  = new DashbroadBO().getDashboard(sdate ,enddate);
		BookBO bo = new BookBO();
		BillsBO billBo= new BillsBO();
		UsersBO usersBO = new UsersBO();
		double revenue=billBo.getSumBills();
		int trans=billBo.getTranspost().size();
		int amountP=bo.getListBooks().size();
		int amountU=usersBO.getListUsers().size();
		Gson gson = new GsonBuilder().create();
		JsonArray jarray = gson.toJsonTree(list).getAsJsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("products", jarray);
		request.setAttribute("jsonDashbroad", jarray);
		request.setAttribute("revenue", revenue);
		request.setAttribute("trans", trans);
		request.setAttribute("amountP", amountP);
		request.setAttribute("amountU", amountU);
		double doanhthu = 0;
		for (Bills b : list) {
			String d = b.getTotal().replace(",", "");
			double price = Double.parseDouble(d);
			doanhthu = doanhthu + price;
		}
		request.setAttribute("doanhthu", doanhthu);

		RequestDispatcher rd = request.getRequestDispatcher("admin\\dashboard.jsp");
		rd.forward(request, response);	}


	

}
