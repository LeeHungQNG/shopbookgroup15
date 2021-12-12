
package dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import model.District;
import model.Province;
import model.Village;
import model.Ward;

public class AddressDAO {
	@SuppressWarnings("unchecked")
	public List<Province> getProvince() {
		List<Province> lst = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String sql = "FROM Province ";
		lst =session.createQuery(sql).getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<District> getListDistrictById(String idp) {
		List<District> lst = new ArrayList<District>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = "FROM District where provinceid = '"+idp+"'  ORDER BY provinceid ASC";
		lst=session.createQuery(sql).getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List<Ward> getWardById(String  idd) {
		List<Ward> lst = new ArrayList<Ward>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = "FROM Ward where districtid='"+idd+"' ORDER BY wardid ASC";	
			lst=session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;

	}
	@SuppressWarnings("unchecked")
	public List<Village> getListVillageById(String idw) {
		List<Village> lst = new ArrayList<Village>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = "FROM Village Where wardid='"+idw+"'  ORDER BY wardid ASC";
			lst=session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;

	}

	public Province getProvinceByID(String idp) {
		   Transaction transaction = null;
	        Province province = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            province = session.get(Province.class, idp);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return province;
	    }
	

	public District getDistrictByID(String idd) {
		 Transaction transaction = null;
	        District district  = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            district = session.get(District.class, idd);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return district;
	}

	public Ward getWardByID(String idw) {
		 Transaction transaction = null;
	        Ward ward = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            ward = session.get(Ward.class, idw);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return ward;
	}
	public Village getVillageById(String idv) {
		 Transaction transaction = null;
	        Village village = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            village = session.get(Village.class, idv);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return village;
	}
	public static void main(String[] args) {
		
		AddressDAO addressDAO = new AddressDAO();
		addressDAO.getDistrictByID("001HH");
	 List<Village> list=addressDAO.getListVillageById("00919");
		for(Village ward:list) {
			System.out.println(ward.getName());
		} 
	}
	}
	

	


