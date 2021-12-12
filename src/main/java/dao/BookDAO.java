
package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.BookDetail;
import model.Books;

public class BookDAO {

	@SuppressWarnings("unchecked")
	public List<Books> getListBooks() {
		List<Books> lst = new ArrayList<Books>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = "From Books";
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;

	}

	@SuppressWarnings("unchecked")
	public List<Books> getListBooksTop() {
		List<Books> lst = new ArrayList<Books>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = "FROM Books";
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		List<Books> list = new ArrayList<Books>();
		if(lst.size()>8) {
			for(Books books:lst) {
				list.add(books);
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Books> getBooksByCategory(long id) {
		List<Books> lst = new ArrayList<Books>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = "FROM Books Where id_Category=" + id + "";
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List<Books> getBooksByName(String name) {

		List<Books> lst = new ArrayList<Books>();
		Transaction transaction = null;
		Session session = HibernateUtil.getOpenSession();
		try {
			transaction = session.beginTransaction();

			String sql = "FROM Books WHERE nameBook LIKE '%" + name + "%'";
			Query query = session.createQuery(sql);
			lst = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
	}

	public Books getBooksByID(long id) {
		Transaction transaction = null;
		Books books = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			books = session.get(Books.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return books;
	}

	public boolean addBook(Books books) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String sql = "INSERT INTO books( addressOut, amount, description, discount, id_Category, id_author, imageDisplay, nameBook, outputDate, priceBook, status, styles) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			Query query = session.createNativeQuery(sql);
			query.setParameter(1, books.getAddressOut());
			query.setParameter(2, books.getAmount());
			query.setParameter(3, books.getDescription());
			query.setParameter(4, books.getDiscount());
			query.setParameter(5, books.getId_Category());
			query.setParameter(6, books.getId_author());
			query.setParameter(7, books.getImageDisplay());
			query.setParameter(8, books.getNameBook());
			query.setParameter(9, books.getOutputDate());
			query.setParameter(10, books.getPriceBook());
			query.setParameter(11, books.getStatus());
			query.setParameter(12, books.getStyles());
			query.executeUpdate();
			transaction.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean editBook(Books books) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String sql = "UPDATE books SET addressOut=:addressOut,amount=:amount,description=:description,"
					+ "discount=:discount,id_Category=:id_Category,id_author=:id_author,imageDisplay=:imageDisplay,nameBook=:nameBook,"
					+ "outputDate=:outputDate,priceBook=:priceBook,status=:status,styles=:styles WHERE id=:id";
			Query query = session.createNativeQuery(sql);
			query.setParameter("addressOut", books.getAddressOut());
			query.setParameter("amount", books.getAmount());
			query.setParameter("description", books.getDescription());
			query.setParameter("discount", books.getDiscount());
			query.setParameter("id_Category", books.getId_Category());
			query.setParameter("id_author", books.getId_author());
			query.setParameter("imageDisplay", books.getImageDisplay());
			query.setParameter("nameBook", books.getNameBook());
			query.setParameter("outputDate", books.getOutputDate());
			query.setParameter("priceBook", books.getPriceBook());
			query.setParameter("status", books.getStatus());
			query.setParameter("styles", books.getStyles());
			query.setParameter("id", books.getId());
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

	public boolean deleteBook(long id) {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			String hql = "DELETE FROM Books WHERE id = :books_id";
			Query query = session.createQuery(hql);
			query.setParameter("books_id", id);
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}



	@SuppressWarnings("unchecked")
	public List<Books> getBookPage(int page) {

		int size = getListBooks().size();
		int residual = size % 9;
		int number = size / 9;
		int pageStart = 0;
		int pageEnd = 0;
		List<Books> lst = new ArrayList<Books>();
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction = null;
		try {
			;
			transaction = session.beginTransaction();

			if (residual > 0 && (page - number == 1)) {
				int result = (page-number)*8;
				pageStart = result;
				pageEnd = size+1;
			} else if (residual > 0 && (page - number == 0)) {
				int result = page - 1;
				pageStart = result * 9;
				pageEnd = page * 9;
			} else if (page < number && page != 0) {
				int result = page - 1;
				pageStart = result * 9;
				pageEnd = page * 9;
			} else if (page == 0) {
				pageStart = 0;
				pageEnd = 9;
			}
			String sql = "FROM Books WHERE id >" + pageStart + " AND id<" + pageEnd + " ORDER BY id ASC";
			Query query = session.createQuery(sql);
			lst = query.getResultList();
			transaction.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return lst;
	}

	public ArrayList<Integer> getNumberPagge() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int size = getListBooks().size();
		int residual = size % 9;
		int number = size / 9;
		int run = 0;
		if (residual > 0) {
			run = number + 2;
		} else {
			run = number + 1;
		}
		for (int i = 1; i < run; i++) {
			list.add(i);
		}
		// TODO Auto-generated method stub
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<BookDetail> getListBookDetails(long id) {
		List<BookDetail> lst = new ArrayList<BookDetail>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = " SELECT * FROM 'booksetail' where idBook=" + id + "";
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;

	}

	public Books updateBook(Books Books) {

		return null;
	}

	public Books getBook(long id) {

		Transaction transaction = null;
		Books Book = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			Book = session.get(Books.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return Book;
	}

	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		List<Books> list = dao.getBooksByName("_");
		for (Books books : list) {
			System.out.println(books.getAmount());
		}
	}

}
