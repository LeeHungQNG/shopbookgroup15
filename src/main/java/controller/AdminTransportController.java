package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BillsDAO;

/**
 * Servlet implementation class AdminTransportController
 */
@WebServlet("/AdminTransportController")
public class AdminTransportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTransportController() {
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
			billsDAO.transport(3, idOD);
		}else {
			String id= request.getParameter("id");
			long idO=Long.parseLong(id);
			billsDAO.transport(2, idO);
		}
		RequestDispatcher rd = request.getRequestDispatcher("AdminManagaTransportController");
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
