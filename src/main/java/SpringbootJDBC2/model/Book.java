package SpringbootJDBC2.model;

public class Book {
	
	private String bookTitle, bookAuthor;
	private int yearPublish,bookID;
	
	public Book(String bookTitle, String bookAuthor, int yearPublish,int bookID) {
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.yearPublish = yearPublish;
		this.bookID = bookID;
	}
	
	public String getBookTitle() { return bookTitle; }
	public String getBookAuthor() { return bookAuthor; }
	public int getYearPublish() { return yearPublish; }
	public int getBookID() { return bookID; }
	
	public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
	public void setBookAuthor(String bookAuthor) { this.bookAuthor = bookAuthor; }
	public void setYearPublish(int yearPublish) { this.yearPublish = yearPublish; }
	public void setBookID(int bookID) { this.bookID = bookID; }

}
