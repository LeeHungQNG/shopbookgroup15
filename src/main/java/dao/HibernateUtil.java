package dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.AuthorBook;
import model.Bills;
import model.BookDetail;
import model.Books;
import model.Cart;
import model.Category;
import model.District;
import model.Item;
import model.Province;
import model.Users;
import model.Village;
import model.Ward;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/bookdb?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "password");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Books.class);
				configuration.addAnnotatedClass(AuthorBook.class);
				configuration.addAnnotatedClass(Bills.class);
				configuration.addAnnotatedClass(Users.class);
				configuration.addAnnotatedClass(Province.class);
				configuration.addAnnotatedClass(District.class);
				configuration.addAnnotatedClass(Ward.class);
				configuration.addAnnotatedClass(Village.class);
				configuration.addAnnotatedClass(BookDetail.class);
				configuration.addAnnotatedClass(Category.class);
				configuration.addAnnotatedClass(Cart.class);
				configuration.addAnnotatedClass(Item.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	public static Session getOpenSession() {
		return getSessionFactory().openSession();

	}
	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
	}
}