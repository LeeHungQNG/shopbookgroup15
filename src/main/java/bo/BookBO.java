package bo;

import java.util.List;

import com.google.gson.JsonArray;

import dao.BookDAO;
import model.Books;

public class BookBO {
BookDAO dao= new BookDAO();
	public List<Books> getListBooks() {
		// TODO Auto-generated method stub
		return dao.getListBooks() ;
	}

	public Books getBookByID(long id) {
		// TODO Auto-generated method stub
		return dao.getBook(id);
	}

	public boolean deleteBooks(int id) {
		// TODO Auto-generated method stub
		return dao.deleteBook(id);
	}

	public boolean addBooks(Books books) {
		return dao.addBook(books);
		
	}

	public List<Books> getListBooksTop() {
		// TODO Auto-generated method stub
		return dao.getListBooksTop();
	}

	public List<Books> getBooksByName(String key) {
		// TODO Auto-generated method stub
		return dao.getBooksByName(key);
	}

	public List<Integer> getPage() {
		// TODO Auto-generated method stub
		return dao.getNumberPagge();
	}

	public List<Books> getListBookByIDC(long idC) {
		// TODO Auto-generated method stub
		return dao.getBooksByCategory(idC);
	}

	public List<Books> getBooksPage(int number) {
		// TODO Auto-generated method stub
		return dao.getBookPage(number);
	}

	public boolean editBooks(Books books) {
		return dao.editBook(books);
	}

	

}
