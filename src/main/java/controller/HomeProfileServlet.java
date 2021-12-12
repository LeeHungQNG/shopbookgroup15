package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.UsersBO;
import model.Users;

/**
 * Servlet implementation class HomeUserProfileServlet
 */
public class HomeProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
		rd.forward(request, response);
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
		
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("uslogin");
		UsersBO dao = new UsersBO();
		String pass_old=request.getParameter("pass-old");
		// KIEEMT TRA XEM MK CU CÓ ĐÚNG VỚI MẬT KHAU NHAP VAO KO
		if(pass_old!=null ) {
			if(pass_old.equals(user.getPass())){
				
			
			String pass_new=request.getParameter("pass_new");
			// UPDATE MAT KHAU MOI
			try {
				dao.UpdatePass(pass_new, user.getId());
				String mess= "Cap Nhat mat khau thanh cong";
				session.setAttribute("SingupSuccess",mess);
				response.sendRedirect("UsersLogoutServlet");	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TRA VE KHI SAI MK
			}else {
				String mess= "mật khẩu cũ bạn nhập không đúng ";
				session.setAttribute("error",mess);

				response.sendRedirect("HomeProfileServlet?id="+user.getId());
			}
			
		}else {
		// CAP NHAT THONG TIN NGUOI DUNG TRA VE AJAX
		String user_name = request.getParameter("val-username");
		String dateBrith = request.getParameter("val-date");
		String address = request.getParameter("val-address");
		String sex = request.getParameter("sex");
		String user_names = request.getParameter("user-name");
		String email = request.getParameter("user-email");
		user.setUsername(user_name);
		user.setDatebirth(dateBrith);
		user.setAddress(address);
		if (sex!=null) {
			user.setSex("Nam");
		} else {
			user.setSex("nữ");
		}
		user.setEmail(email);
		user.setNameDisplay(user_names);
		dao.UpdateAccount(user);
		response.sendRedirect("HomeProfileServlet?id="+user.getId());
		}
	}

}
