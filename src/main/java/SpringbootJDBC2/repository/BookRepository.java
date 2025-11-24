package SpringbootJDBC2.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import SpringbootJDBC2.model.Book;

@Repository
public class BookRepository implements BookImp{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BookRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private RowMapper<Book> rowMapper = (rs, column) ->
	 			new Book(rs.getString("BookTitle"),rs.getString("BookAuthor"),rs.getInt("YearPublish"), rs.getInt("BookID")
	 		);
	 			
	@Override
	public int createBook(Book book) {
		String sql = "Insert into Book (BookTitle, BookAuthor, YearPublish, BookID) values (?,?,?,?)";
		return jdbcTemplate.update(sql, book.getBookTitle(), book.getBookAuthor(), book.getYearPublish(), book.getBookID());
	}
	
	@Override
	public List<Book> getAllBook() {
		String sql = "Select * from Book";
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public Book getBookByID(int ID) {
		String sql = "Select * from Book where BookID = ?";
		return jdbcTemplate.queryForObject(sql, rowMapper, ID);
	}
	
	@Override
	public int UpdateBook(Book book) {
		String sql = "Update Book set BookTitle = ?, BookAuthor = ?, YearPublish = ? where BookID = ?";
		return jdbcTemplate.update(sql, book.getBookTitle(), book.getBookAuthor(), book.getYearPublish(), book.getBookID());
	}
	
	 @Override
    public int partialUpdate(Book book) {
        StringBuilder sql = new StringBuilder("UPDATE Book SET ");
        List<Object> params = new ArrayList<>();

        if (book.getBookTitle() != null) {
            sql.append("BookTitle = ?, ");
            params.add(book.getBookTitle());
        }
        if (book.getBookAuthor() != null) {
            sql.append("BookAuthor = ?, ");
            params.add(book.getBookAuthor());
        }
        if (book.getYearPublish() != null) {
            sql.append("YearPublish = ?, ");
            params.add(book.getYearPublish());
        }

        // Remove last comma
        sql.setLength(sql.length() - 2);
        sql.append(" WHERE BookID = ?");
        params.add(book.getBookID());

        return jdbcTemplate.update(sql.toString(), params.toArray());
    }
	
	@Override
	public int DeleteBookByID(int ID) {
		String sql = "Delete from Book where BookID = ?";
		return jdbcTemplate.update(sql,ID);
	}
	 
}