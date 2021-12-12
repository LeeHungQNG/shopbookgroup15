package controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.CartBO;
import bo.UsersBO;
import model.Users;

/**
 * Servlet implementation class UsersRegisterServlet
 */
public class UsersRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// khai bĂ¡o session
		HttpSession session = request.getSession();
		UsersBO s = new UsersBO();
		CartBO cartBO = new CartBO();
		String userName = request.getParameter("user-name");
		String email = request.getParameter("user-email");
		
		if (!s.checkAccount(userName, email)) {
			Users users = new Users();
			users.setUsername(request.getParameter("user-name"));
			users.setEmail(request.getParameter("user-email"));
			users.setPass(request.getParameter("user-password"));
			users.setRole("USER");
			users.setNameDisplay(request.getParameter("user-showname"));
			
			String mes = "";
			try {
				if (s.addAccount(users)) {
					mes = "Đăng ký tài khoản thành công.Vui lòng đăng nhập.";
				//	Users usersR=s.
					session.setAttribute("SingupSuccess", mes);
					response.sendRedirect("login.jsp");
				} else {
					mes = "Lỗi!";
					session.setAttribute("SingupError", mes);
					response.sendRedirect("register.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else

		{
			String mes = "Tài khoản hoặc email đã tồn tại!";
			session.setAttribute("AcccExists", mes);
			response.sendRedirect("login.jsp");
		}

	}

}
