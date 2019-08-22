package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			//auto commit 되지 않도록 설정
			con.setAutoCommit(false);
			String sql1 = " select max(no)+1 as no from board ";
			String sql2 = " insert into board(no, id, title, contents) "
						+ " values(?,?,?,?) ";
			String sql3 = " insert into boardfile(rfilename, sfilename, bno) "
						+ " values(?,?,?) ";
			
			stmt1 = con.prepareStatement(sql1);
			rs = stmt1.executeQuery();
			int no=0;
			if(rs.next()) {
				no = rs.getInt("no");
			}
			stmt2 = con.prepareStatement(sql2);
			stmt2.setInt(1, no);
			stmt2.setString(2, "ssafy");
			stmt2.setString(3, "처음하는 jdbc");
			stmt2.setString(4, "잫되나요?");
			stmt2.executeUpdate();
			if(true) throw new RuntimeException("트랜잭션을 위한 exception 발생");
			stmt3 = con.prepareStatement(sql3);
			stmt3.setString(1,  "a.txt");
			stmt3.setString(2,  "a.txt");
			stmt3.setInt(3, no);
			stmt3.executeUpdate();
			
			con.commit();	//모든 문장이 error없이 수행되었다면 commit
			
		} catch (Exception e) {
			 e.printStackTrace();
			 //error가 났다면 rollback
			 DBUtil.rollback(con);
		}finally {
			DBUtil.close(rs);
			DBUtil.close(stmt1);
			DBUtil.close(stmt2);
			DBUtil.close(stmt3);
			DBUtil.close(con);
			
		}
	}

}
