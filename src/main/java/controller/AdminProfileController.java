package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import bo.UsersBO;
import dao.UsersDAO;
import model.Users;

/**
 * Servlet implementation class AdminProfileController
 */
@WebServlet("/AdminProfileController")
public class AdminProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProfileController() {
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
		RequestDispatcher rd = request.getRequestDispatcher("admin\\adminprofile.jsp");
		rd.forward(request, response);	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("uslogin");
		UsersBO dao= new UsersBO();
		String username = request.getParameter("username");
		String passold = request.getParameter("pass-old");
		String passnew = request.getParameter("pass-new");
		if(user.getUsername().equals(username)&&user.getPass().equals(passold)) {
			user.setPass(passnew);
			user.setUsername(username);
			try {
				dao.UpdateAccount(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("mess", "Thảy đổi thành công");

			
		}else {
			session.setAttribute("mess", "Sai mật khẩu hoặc username");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("admin\\adminprofile.jsp");
		rd.forward(request, response);	
	}

}
