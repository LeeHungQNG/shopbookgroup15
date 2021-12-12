package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.AddressBO;
import bo.BillsBO;
import bo.CartBO;
import dao.AddressDAO;
import dao.CartDAO;
import dao.SendMail;
import model.Bills;
import model.BillsDetail;
import model.Cart;
import model.District;
import model.Province;
import model.Users;
import model.Ward;

/**
 * Servlet implementation class HomeBillServlet
 */
public class HomeBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeBillServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		AddressBO addressBO = new AddressBO();
		// get session ra 
		HttpSession session = request.getSession();
		String status = request.getParameter("status");
		CartBO cartbo= new CartBO();
		// get tài khoản đăg nhặp
		Users user = (Users) session.getAttribute("uslogin");
		// lấy các dữ liệu đơn hàng
		String user_name = request.getParameter("user-name");
		String town_ward = request.getParameter("town_ward");
		String tp = request.getParameter("country");
		String qh = request.getParameter("district");
		String px = request.getParameter("town_ward");
		String tt = request.getParameter("village");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String note = request.getParameter("note");
		// lấy địa chi đơn hàng
		Province citys = addressBO.getProvinceByID(tp);
		District district = addressBO.getDistrict(qh);
		Ward ward = addressBO.getWardByID(px);
		String diachi = citys.getName() + "/" + district.getName() + "/" + px + "/" + address;
		BillsBO billsBO = new BillsBO();
		// kiếm tra trạng thái và xứ lý đơn hang
		switch (status) {
		case "addbill":
			if (note == null) {
				note = "";
			}
			Cart cart = (Cart) session.getAttribute("cart");
			Date date=java.util.Calendar.getInstance().getTime();  
			Bills bill = new Bills();
			bill.setAddress(diachi);
			bill.setNumberPhone(phone);
			bill.setEmail(email);
			bill.setNote(note);
			bill.setNameRecevie(user_name);
			bill.setDatePay(date);
			bill.setNumberHouse(town_ward);
			bill.setStatus(0);
			double total = cart.getTotalPrice();
			String price=String.valueOf(total);
			bill.setTotal(price);
			try {
				billsBO.addBill(bill);

			} catch (Exception e) {
				e.printStackTrace();
			}

			//cập nhật lại đơn hàng 
			session.removeAttribute("cart");
			String tb = "Bạn Đã Đặt đơn hàng thành công ! Tiếp tục mua sắm ";
			cartbo.deleteCart(cart.getId());
			cart.setTotalPrice(0);
			cart.setAmount(0);
			cartbo.updateCart(cart);
			session.setAttribute("paid", tb);
			response.sendRedirect("HomeShoppingCart");
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
