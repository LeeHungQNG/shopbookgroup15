package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.AuthorBook;
import model.Category;

public class AuthorDao {

	@SuppressWarnings("unchecked")
	public List<AuthorBook> getListAuthor() {

		List<AuthorBook> lst = new ArrayList<AuthorBook>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = " FROM AuthorBook";
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

	public boolean addAuthor(AuthorBook author) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction=null;
		try {
             transaction = session.beginTransaction();
             String sql ="INSERT INTO author( description, nameAuthor) VALUES (?,?)";
             Query query =session.createNativeQuery(sql);
             query.setParameter(1, author.getDescription());
             query.setParameter(2, author.getNameAuthor());
             query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteAuthorByID(long id) {
		Session session = HibernateUtil.getOpenSession();
        Transaction transaction = null;
		try {
			  transaction = session.beginTransaction();
			String hql = "DELETE FROM AuthorBook WHERE id = :author_id";
			Query query = session.createQuery(hql);
			query.setParameter("author_id", id);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	
	}

}
