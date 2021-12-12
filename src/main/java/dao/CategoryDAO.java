package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Category;

public class CategoryDAO {
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	public List<Category> getListCategory() {

		List<Category> lst = new ArrayList<Category>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = " FROM Category";
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

	public boolean addCategory(Category ca) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction=null;
		try {
             transaction = session.beginTransaction();
             String sql ="INSERT INTO category (nameCategory) VALUES (?)";
             Query query =session.createNativeQuery(sql);
             query.setParameter(1, ca.getNameCategory());
             query.executeUpdate();
             transaction.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Category getCategoryByID(long id) {
		Transaction transaction = null;
		Category category = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			category = session.get(Category.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return category;
	}

	public Boolean deleteCategory(long id) {
		Session session = HibernateUtil.getOpenSession();
        Transaction transaction = null;

		try {
			  transaction = session.beginTransaction();
			String hql = "DELETE FROM Category WHERE id = :category_id";
			Query query = session.createQuery(hql);
			query.setParameter("category_id", id);
			query.executeUpdate();
            transaction.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	} public static void main(String[] args) {
		CategoryDAO categoryDAO = new CategoryDAO();
		Category category = new Category();
		category.setNameCategory("đ");
		categoryDAO.addCategory(category);
	}

}
