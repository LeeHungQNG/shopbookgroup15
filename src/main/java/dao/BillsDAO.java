package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Bills;
import model.Province;

public class BillsDAO {

	@SuppressWarnings("unchecked")
	public List<Bills> getListOrder() {
		List<Bills> lst = new ArrayList<Bills>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = "FROM Bills WHERE status = 0 ";
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List<Bills> getBills() {
		List<Bills> lst = new ArrayList<Bills>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = " FROM Bills WHERE status = 2 ";
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List<Bills> getTranspost() {
		List<Bills> lst = new ArrayList<Bills>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = " FROM Bills WHERE status = 1 ";
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

	public boolean getAddData(Bills bill) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean transport(int status, long id) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String hql = "UPDATE Bills SET status=:status WHERE id=:id";
			Query query = session.createQuery(hql);
			query.setParameter("status", status);
			query.setParameter("id", id);
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public Bills getBillsById(long id) {
		Transaction transaction = null;
		Bills bills = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			bills = session.get(Bills.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return bills;
	}

	public boolean cancelOrder(long id) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String hql = "DELETE FROM Bills WHERE id=:id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public double getSumBills() {
		List<Bills> list = new ArrayList<Bills>();
		list = getBills();
		double revenu = 0;
		for (Bills b : list) {
			String d = b.getTotal().replace(",", "");
			double price = Double.parseDouble(d);
			revenu = revenu + price;
		}
		return revenu;
	}

	@SuppressWarnings("unchecked")
	public List<Bills> getCancelOrder() {
		List<Bills> lst = new ArrayList<Bills>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = " FROM Bills WHERE status = 3 ";
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

	public boolean addBills(Bills bill) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String sql = "INSERT INTO bills( address, datePay, email, nameRecevie, note, numberHouse, numberPhone, status, total) VALUES (?,?,?,?,?,?,?,?,?)";
			Query query = session.createNativeQuery(sql);
			query.setParameter(1, bill.getAddress());
			query.setParameter(2, bill.getDatePay());
			query.setParameter(3, bill.getEmail());
			query.setParameter(4, bill.getNameRecevie());
			query.setParameter(5, bill.getNote());
			query.setParameter(6, bill.getNumberHouse());
			query.setParameter(7, bill.getNumberPhone());
			query.setParameter(8, bill.getStatus());
			query.setParameter(9, bill.getTotal());
			query.executeUpdate();
            transaction.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateStatus(long id,int status) {
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();

	            String hql = "UPDATE Bills set status = :status " + "WHERE id = :billsid";
	            Query query = session.createQuery(hql);
	            query.setParameter("status", status);
	            query.setParameter("billsid", id);
	            int result = query.executeUpdate();

	            transaction.commit();
	            return true;
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
			return false;
	}

}
