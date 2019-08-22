package wsAdjava03;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
	public void insertBook(Book book)throws SQLException;
	public void updateBook(Book book)throws SQLException;
	public void deleteBook(String isbn)throws SQLException;
	public Book findBook(String isbn) throws SQLException;
	public List<Book> listBooks()throws SQLException;
}
