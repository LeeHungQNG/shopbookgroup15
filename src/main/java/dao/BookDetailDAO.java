package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.BookDetail;
import model.Books;
import model.Category;

public class BookDetailDAO {

	@SuppressWarnings("unchecked")
	public List<BookDetail> getListBookDetails(long id) {

		List<BookDetail> lst = new ArrayList<BookDetail>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = " FROM BookDetail WHERE idBook="+id;
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

	public boolean addBookDetails(BookDetail bookDetail) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction=null;
		try {
             transaction = session.beginTransaction();
             String sql ="INSERT INTO booksetail(idBook, imageLink) VALUES (?1,?2)";
             Query query =session.createNativeQuery(sql);
             query.setParameter(1, bookDetail.getIdBook());
             query.setParameter(2, bookDetail.getImageLink());
             query.executeUpdate();
             transaction.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<BookDetail> getBookDetailByID(Long id_book) {
		List<BookDetail> lst = new ArrayList<BookDetail>();
		Transaction transaction = null;
		Session session = HibernateUtil.getOpenSession();
		try {
			transaction = session.beginTransaction();

			String sql = "FROM BookDetail WHERE idBook="+id_book;
			Query query = session.createQuery(sql);
			lst = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

	public boolean deleteBookDetailByID(long id) {
		Session session = HibernateUtil.getOpenSession();
        Transaction transaction = null;

		try {
			  transaction = session.beginTransaction();
			String hql = "DELETE FROM BookDetail WHERE id=:id";
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

}
