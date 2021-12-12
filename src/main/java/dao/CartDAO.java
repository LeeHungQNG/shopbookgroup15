package dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.NamedQuery;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Bills;
import model.BillsDetail;
import model.Books;
import model.Cart;
import model.Category;
import model.Item;

public class CartDAO {

	public String totalCart() {
		// TODO Auto-generated method stub
		return null;
	}

	public Cart getCart(long id) {
		Transaction transaction = null;
		Cart cart = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			cart = session.get(Cart.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return cart;
	}

	public boolean updateItem(Item item) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			String hql = "UPDATE Item SET quantity=:quantity WHERE id=:id";
			Query query = session.createQuery(hql);
			query.setParameter("quantity", item.getQuantity());
			query.setParameter("id", item.getId());
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

	public Cart addItem(Item item) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(item);
			transaction.commit();
			return null;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	public Cart addCart(Cart cart) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
		 session.save(cart);
			transaction.commit();
			return null;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Item> getListItem(long id) {
		List<Item> lst = new ArrayList<Item>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = "FROM Item Where cart_id=" + id + "";
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

	@SuppressWarnings("unchecked")
	public Cart getCartByIDU(long id) {
		List<Cart> lst = new ArrayList<Cart>();
		Session session = HibernateUtil.getOpenSession();
		Cart cart = null;
		try {
			String sql = "FROM Cart Where id_User=" + id + "";
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(lst.size()>0) {
			cart=lst.get(0);
		}
		return cart;
	}

	public boolean deleteCart(long id) {
		Session session = HibernateUtil.getOpenSession();
        Transaction transaction = null;
		try {
			  transaction = session.beginTransaction();
			String hql = "DELETE FROM Item WHERE cart_id = :cart_id";
			Query query = session.createQuery(hql);
			query.setParameter("cart_id", id);
			query.executeUpdate();
            transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean updateCart(Cart cart) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String hql = "UPDATE Cart SET totalPrice=:totalPrice,amount=:amount WHERE id=:id";
			Query query = session.createQuery(hql);
			query.setParameter("totalPrice",cart.getTotalPrice());
			query.setParameter("amount",cart.getAmount());
			query.setParameter("id",cart.getId());

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

	public boolean deleteProductByIDCart(long idSP, long id) {
		Session session = HibernateUtil.getOpenSession();
        Transaction transaction = null;
		try {
			  transaction = session.beginTransaction();
			String hql = "DELETE FROM Item WHERE cart_id = :cart_id AND idBook=:idBook";
			Query query = session.createQuery(hql);
			query.setParameter("cart_id", id);
			query.setParameter("idBook", idSP);
			query.executeUpdate();
            transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean updateCartByIDCart(long cartID, long idSP, int amount) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String hql = "UPDATE Item SET quantity=:quantity  WHERE idBook=:idBook";
			Query query = session.createQuery(hql);
			query.setParameter("quantity",amount);
			query.setParameter("idBook",idSP);
		 query.executeUpdate();
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
	@SuppressWarnings("unchecked")
	public List<Item> getListItemByID(long id,long idBook) {
		List<Item> lst = new ArrayList<Item>();
	
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = "FROM Item Where cart_id=" + id + "AND idBook="+idBook +"";
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}


}
