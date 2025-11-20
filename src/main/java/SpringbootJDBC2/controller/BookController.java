package SpringbootJDBC2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SpringbootJDBC2.service.BookService;
import SpringbootJDBC2.model.Book;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*")
public class BookController {
	
	private final BookService serv;
	
	@Autowired
	public BookController(BookService serv) {
		this.serv = serv;
	}
	
	@PostMapping
	public String createBook(@RequestBody Book book) {
		serv.createBook(book);
		return "Book Created";
	}
	
	@GetMapping
	public List<Book> getAllBook(){
		return serv.getAllBook();
	}
	
	@GetMapping("/{IDFilter}")
	public Book getBookByID(@RequestParam int ID) {
		return serv.getBookByID(ID);
	}
	
	@PutMapping("/{ID}")
	public String updateBook(@PathVariable int ID, @RequestBody Book book) {
		book.setBookID(ID);
		serv.updateBook(book);
		return "ID : " + ID + " Updated";
	}
	
	@DeleteMapping("/{ID}")
	public String deleteBookByID(@PathVariable int ID) {
		serv.deleteBookByID(ID);
		return "ID : " + ID + " Deleted";
	}
	
	
	

}
