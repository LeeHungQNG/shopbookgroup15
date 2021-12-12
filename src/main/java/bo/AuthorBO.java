package bo;

import java.util.ArrayList;
import java.util.List;

import dao.AuthorDao;
import model.AuthorBook;
import model.Category;

public class AuthorBO {
AuthorDao authorDao= new AuthorDao();
	public List<AuthorBook> getListAuthor() {
		// TODO Auto-generated method stub
		return authorDao.getListAuthor();
	}

	public boolean addAuthor(AuthorBook author) {
		return authorDao.addAuthor(author);
		// TODO Auto-generated method stub
		
	}
	public boolean deleteAuthor(long id) {
		return authorDao.deleteAuthorByID(id);
	}


}
