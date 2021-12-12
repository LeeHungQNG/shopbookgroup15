package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Users;

import javax.servlet.http.*;

public class SercurtyFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		String servletPath = request.getServletPath();
		
		boolean isStaticResource = request.getRequestURI().startsWith("/viewroot/");
		boolean isAdmin = request.getRequestURI().startsWith("/admin/viewroot/");
		
		HttpServletRequest wrapRequest = request;
		//Kiêm tra các trạng trai lôi khi request 
		String url = request.getRequestURI();
		if (!ErrorServlet(request, response, response.getStatus())) {
			response.sendRedirect("login.jsp");
			filterChain.doFilter(wrapRequest, response);
			return;
		}
		if (url.indexOf("/viewroot") > 0 || url.indexOf("/admin/viewroot/") > 0) {
			filterChain.doFilter(request, response);
		}
		

		String[] listpath = { "/Home", "/HomeProductsServlet", "/blog.jsp", "/contact.jsp", "/login.jsp",
				"/UsersLoginServlet", "/shoping-cart.jsp" ,"/HomeSearchProduct","/UsersRegisterServlet","/HomeProductsDetail"};

		String[] listpathUser = {"/CartControllerServlet", "/HomeUserProfileServlet", "/UserEditAvata", "/HomeProfileServlet","/account.jsp",
				"/checkout.jsp","/HomeCheckoutServlet", "/HomeBillServlet","/UsersLogoutServlet","/HomeCartServlet","/HomeShoppingCart"};

		String[] listPathAdmin = { "/AdminController","/AdminAddCategory","/AdminAddDetailProduct","/AdminBillsController","/AdminChangeRoleController","/AdminController","/AdminEditBookController",
				"/AdminDeleteCategory","/AdminDeleteBookDetail","/AdminDeleteProducts","/AdminDeleteUser","/AdminEditBookController","/AdminManagaBillController"
				,"/AdminManagaCategoryController","/AdminManagaBookController","/AdminManagaTransportController","/AdminManagaUserController","/AdminManageOrderController","/AdminMangageAuthorController",
				"/AdminOrderController","/AdminBookDetailsController","/AdminProfileController","/AdminTransportController","/UsersLogoutServlet","/AdminOrderCancelController","/AdminAuthorController"};
		 
		
		for (String path : listpath) {			
			if (servletPath.equals(path)) {
				filterChain.doFilter(request, response);
				break;
			}
		}
		
		Users loginedUser = (Users) session.getAttribute("uslogin");
		if (loginedUser != null) {
			if (loginedUser.getRole().equals("USER")) {
				for (String pathUser : listpathUser) {
					if (servletPath.equals(pathUser)) {
						filterChain.doFilter(request, response);
						break;
					}

				}
			} else if (loginedUser.getRole().equals("ADMIN")) {
				for (String pathAdmin : listPathAdmin) {
					if (servletPath.equals(pathAdmin)) {
						filterChain.doFilter(request, response);
						break;

					}
				}
			} else {
				// trả về đăng nhâp
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect("/login.jsp");
			}
		} else {
		}

	}
	// kiếm tra các trạng thái lỗi của server
	public boolean ErrorServlet(HttpServletRequest request, HttpServletResponse response, int statusCode) {
		HttpSession session = request.getSession();
		if (statusCode > 0) {
			String error = "";
			String codeError = "";
			if (statusCode == 404) {
				error = "Error 404";
				session.setAttribute("msgerror", error);
				codeError = "404";
				session.setAttribute("codeError", codeError);
				return false;
			} else if (statusCode == 500) {
				error = "Error 500";
				session.setAttribute("msgerror", error);
				codeError = "500";

				session.setAttribute("codeError", codeError);
				return false;
			} else if (statusCode == 405) {
				error = "Error 405";
				session.setAttribute("msgerror", error);
				codeError = "405 ";
				session.setAttribute("codeError", codeError);
				return false;
			} else if (statusCode == 415) {
				error = "Error 415";
				session.setAttribute("msgerror", error);
				codeError = "415 ";
				session.setAttribute("codeError", codeError);
				return false;

			}

		}
		return true;
	}

	@Override
	public void destroy() {

	}
}
