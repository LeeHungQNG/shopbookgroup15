package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import model.Bills;

public class DashboardDAO {
	@SuppressWarnings("unchecked")
	public List<Bills> getDashboard(String tungay, String denngay) {
		List<Bills> lst = new ArrayList<Bills>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = " FROM Bills WHERE datePay >'"+tungay+"' AND  datePay< '"+ denngay+"' "+"AND status = 2"; 
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	
	}

}
