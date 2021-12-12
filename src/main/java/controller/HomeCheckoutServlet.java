package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.AddressBO;
import model.District;
import model.Users;
import model.Village;
import model.Ward;

/**
 * Servlet implementation class HomeCheckoutServlet
 */
public class HomeCheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeCheckoutServlet() {
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
		HttpSession session= request.getSession();
		Users user = (Users) request.getAttribute("uslogin");
		
		AddressBO addressBO = new AddressBO();	
		// LẤY CÁC ID CỦA ADRESSS DUOC GUI LEN 
		String id_province=request.getParameter("id_province");
		String id_dictricst = request.getParameter("id_dictricst");
		String id_ward = request.getParameter("id_ward");

		// KIEM TRA ID DUOC GUI TOI LA QUAN/THANH PHO ...		
		String status = request.getParameter("status");
		switch (status) {
		case "district":
			if(id_province != null) {
				//GET DATA DIA CHI QUAN VA TAO HTML GUI TRA VE VIEW QUA AJAX
				String textdictics = "<select id=\"district\" class=\"custom-select d-block w-100\" required onchange=\"load_town_ward(this.value);\" name=\"district\"> <option value=\"\"></option>"; 
				for (District ls : addressBO.getDistrictById(id_province)) {
					textdictics += "<option value=\""+ls.getDistrictid()+"\">"+ls.getName()+"</option>";
				}
				textdictics += "</select>"; 
				response.getWriter().println(textdictics);  
			}
			break;
		case "town_ward":
			if(id_dictricst != null) {
				//GET DATA DIA CHI XA VA TAO HTML GUI TRA VE VIEW QUA AJAX

				String text_town_ward = "<select id=\"town_ward\" class=\"custom-select d-block w-100\" required onchange=\"load_village(this.value);\" name=\"town_ward\"> <option value=\"\"></option>";
				for (Ward ls : addressBO.getWardById(id_dictricst)) {
					text_town_ward += "<option value=\""+ls.getWardid()+"\">"+ls.getName()+"</option>";
				}
				text_town_ward += "</select>"; 
				response.getWriter().println(text_town_ward);  
			}
			break;
		case "village":
			//GET DATA DIA CHI LANG VA TAO HTML GUI TRA VE VIEW QUA AJAX

			if(id_ward != null) {
				String text_town_ward = "<select id=\"village\" class=\"custom-select d-block w-100\" required onchange=\"showship();\" name=\"village\"> <option value=\"\"></option>";
				for (Village ls : addressBO.getListVillageByid(id_ward)) {
					text_town_ward += "<option value=\""+ls.getName()+"\">"+ls.getName()+"</option>";
				}
				text_town_ward += "</select>"; 
				response.getWriter().println(text_town_ward);  
			}
			break;
		default:
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
