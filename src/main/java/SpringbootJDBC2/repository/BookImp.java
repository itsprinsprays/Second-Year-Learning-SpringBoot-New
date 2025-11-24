package SpringbootJDBC2.repository;

import SpringbootJDBC2.model.Book;
import java.util.List;

public interface BookImp {

	int createBook(Book book);
	List<Book> getAllBook();
	Book getBookByID(int ID);
	int UpdateBook(Book book);
	int partialUpdate(Book book);
	int DeleteBookByID(int ID);
	
}
