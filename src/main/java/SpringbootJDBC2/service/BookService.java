package SpringbootJDBC2.service;

import SpringbootJDBC2.model.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringbootJDBC2.repository.BookRepository;

@Service
public class BookService {
	
	private BookRepository repo;
	
	@Autowired
	public BookService(BookRepository repo) {
		this.repo = repo;
	}
	
	public String createBook(Book book) {
		repo.createBook(book);
		return "Book Created";
	}
	
	public List<Book> getAllBook() {
		return repo.getAllBook();
	}
	
	public Book getBookByID(int ID) {
		return repo.getBookByID(ID);
	}
	
	public String updateBook(Book book) {
		int rows = repo.UpdateBook(book);
		   if (rows == 0) {
	            throw new RuntimeException("Book ID not found: " + book.getBookID());
	        }
		return "Book Info Updated";
	}
	
	public String partialUpdateBook(Book book) {
		int rows = repo.partialUpdate(book);
		if(rows == 0) {
			throw new RuntimeException("Book ID Not Found : " + book.getBookID());
		}
		return "Book ID : " + book.getBookID() + " is Updated";
	}
	
	public String deleteBookByID(int ID) {
		repo.DeleteBookByID(ID);
		return "Book Deleted";
	}
	
	

}
