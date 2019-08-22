package wsAdjava03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class BookDAOImp implements BookDAO {
	int count;

	@Override
	public void insertBook(Book book) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " insert into book(isbn, title, author, publisher, price, description) "
						+" values(?,?,?,?,?,?) ";
			stmt =con.prepareStatement(sql);
			int idx=1;
			stmt.setString(idx++, book.getIsbn());
			stmt.setString(idx++, book.getTitle());
			stmt.setString(idx++, book.getAuthor());
			stmt.setString(idx++, book.getPublisher());
			stmt.setInt(idx++, book.getPrice());
			stmt.setString(idx++, book.getDescription());
			stmt.executeUpdate();
		} finally {
			 DBUtil.close(stmt);
			 DBUtil.close(con);
		}
		
	}

	@Override
	public void updateBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(String isbn) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book findBook(String isbn) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from member where isbn = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, isbn);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new Book(rs.getString("isbn")
								, rs.getString("title")
								, rs.getString("author")
								, rs.getString("publisher")
								, rs.getInt("price")
								, rs.getString("description"));
			}                     
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return null;
	}

	@Override
	public List<Book> listBooks() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
