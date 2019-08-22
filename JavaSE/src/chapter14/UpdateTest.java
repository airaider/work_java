package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " update emp set ename=?, sal=? where empno=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "ssafy1");
			stmt.setInt(2, 5000);		 
			stmt.setInt(3, 3333);		
			int row = stmt.executeUpdate(); 
			System.out.printf("%d행이 수행되었습니다.", row);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

}
