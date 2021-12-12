package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BillsDAO;
import model.Bills;

/**
 * Servlet implementation class AdminTransportController
 */
@WebServlet("/AdminOrderController")
public class AdminOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOrderController() {
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
		String idD= request.getParameter("idD");
		BillsDAO billsDAO = new BillsDAO();
		if(idD!=null) {
			long idOD=Long.parseLong(idD);
			billsDAO.cancelOrder(idOD);
		}else {
			String id= request.getParameter("id");
			long idO=Long.parseLong(id);
			billsDAO.transport(1, idO);
		}
		RequestDispatcher rd = request.getRequestDispatcher("AdminManageOrderController");
		rd.forward(request, response);		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		

	}

}
