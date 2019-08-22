package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " insert into emp(empno, ename, sal) "
					   + " values(?,?,?) ";
			stmt = con.prepareStatement(sql);
			//데이터 설정 setXXX(?번호, 설정할 데이터)
			stmt.setInt(1, 3333);		 //1번째 ?에 int타입으로 3333 데이터를 설정
			stmt.setString(2, "ssafy");	 //2번째 ?에 string타입으로 ssafy 데이터를 설정 
			stmt.setInt(3, 4500);		 //3번째 ?에 int타입으로 4500 데이터를 설정
			int row = stmt.executeUpdate(); //insert, delete, update문을 수행
			System.out.printf("%d행이 수행되었습니다.", row);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

}
