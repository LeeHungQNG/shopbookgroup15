package bo;

import java.util.List;

import dao.BookDetailDAO;
import model.BookDetail;

public class BookDetailBO {
BookDetailDAO bookDetailDAO = new BookDetailDAO();
	public List<BookDetail> getListBookDetails(long id) {
		// TODO Auto-generated method stub
		return bookDetailDAO.getListBookDetails(id);
	}

	public boolean addBookDetail(BookDetail bookDetail) {
		return bookDetailDAO.addBookDetails(bookDetail);
		
	}

	public List<BookDetail> getBookDetailByID(Long id_book) {
		// TODO Auto-generated method stub
		return bookDetailDAO.getBookDetailByID(id_book);
	}

	public boolean deleteBookDetailByID(long id) {
		return bookDetailDAO.deleteBookDetailByID(id);
		// TODO Auto-generated method stub
		
	}

}
