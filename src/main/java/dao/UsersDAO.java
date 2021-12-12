package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Books;
import model.Category;
import model.Users;


public class UsersDAO {

	public Users checkLogin(String username, String pass) {
	
		Transaction transaction = null;
		Users users = null;
		Session session = HibernateUtil.getOpenSession();
		try {
			transaction = session.beginTransaction();

			String sql = "FROM Users WHERE username=:username AND pass=:pass";
			Query query = session.createQuery(sql);
			query.setParameter("username", username);
			query.setParameter("pass", pass);
			users = (Users) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return users;
	}

	public boolean addAccount(Users user) throws Exception {
		Session session = HibernateUtil.getOpenSession();
		Transaction transaction=null;
		try {
             transaction = session.beginTransaction();
             String sql ="INSERT INTO users(address, datebirth, email, idBills, nameDisplay, pass, role, sex, username) VALUES (?,?,?,?,?,?,?,?,?)";
             Query query =session.createNativeQuery(sql);
             query.setParameter(1,user.getAddress() );
             query.setParameter(2,user.getDatebirth() );
             query.setParameter(3, user.getEmail());
             query.setParameter(4,user.getIdBills() );
             query.setParameter(5,user.getNameDisplay() );
             query.setParameter(6,user.getPass() );
             query.setParameter(7, user.getRole());
             query.setParameter(8,user.getSex() );
             query.setParameter(9, user.getUsername());
             query.executeUpdate();
             transaction.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean updateUser(Users user) {
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "UPDATE Users SET address=:address,datebirth=:datebirth,email=:email,idBills=:idBills,nameDisplay=:nameDisplay,pass=:pass,role=:role,sex=:sex,username=:username WHERE id=:id";
            Query query = session.createQuery(hql);
            query.setParameter("address",user.getAddress() );
            query.setParameter("datebirth",user.getDatebirth() );
            query.setParameter("email",user.getEmail() );
            query.setParameter("idBills",user.getIdBills() );
            query.setParameter("nameDisplay",user.getNameDisplay() );
            query.setParameter("pass",user.getPass() );
            query.setParameter("role", user.getRole());
            query.setParameter("username",user.getUsername() );
            query.setParameter("sex", user.getSex());
            query.setParameter("id", user.getId());


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

	public boolean editPasswordAccount(String pass, long id) throws Exception {
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();

	            String hql = "UPDATE Users set pass = :pass " + "WHERE id = :user_id";
	            Query query = session.createQuery(hql);
	            query.setParameter("pass", pass);
	            query.setParameter("user_id", id);
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

	@SuppressWarnings("unchecked")
	public List<Users> getListUsers() {
		List<Users> lst = new ArrayList<Users>();
		Session session = HibernateUtil.getOpenSession();
		try {
			String sql = " FROM Users";
			lst = session.createQuery(sql).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lst;
		
	}

	public boolean deleteUser(long id) {
		Session session = HibernateUtil.getOpenSession();
        Transaction transaction = null;

		try {
			  transaction = session.beginTransaction();
			String hql = "DELETE FROM Users WHERE id = :user_id";
			Query query = session.createQuery(hql);
			query.setParameter("user_id", id);
			query.executeUpdate();
            transaction.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	public Users getUsersById(long id) {
		
		Transaction transaction = null;
		Users users = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			users = session.get(Users.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return users;
	}

	public Users getUsersByName(String name) {
		
		return null;
	}

	public boolean changeRole(Users user) throws Exception {
		String role=null;
		if(user.getRole().equals("ADMIN")){
			role="USER";
		}else {
			role="ADMIN";
		}
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();

	            String hql = "UPDATE Users set role = :role " + "WHERE id = :user_id";
	            Query query = session.createQuery(hql);
	            query.setParameter("role", role);
	            query.setParameter("user_id", user.getId());
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
