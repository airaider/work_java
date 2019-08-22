package chapter14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private static String id = "ssafy";
	private static String pw = "ssafy";
	static {
		try {
			//1. Driver loading
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("디비 로딩 실패");
		}
	}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,id,pw);
	}
	public static void close(Connection con) {
		if(con!=null) {
			try {con.close();} catch (Exception e) {}
		}
	}
	public static void close(PreparedStatement stmt) {
		if(stmt!=null) {
			try {stmt.close();} catch (Exception e) {}
		}
	}
	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {rs.close();} catch (Exception e) {}
		}
	}
	public static void rollback(Connection con) {
		if(con!=null) {
			try {con.close();} catch (Exception e) {}
		}
	}
	
}
