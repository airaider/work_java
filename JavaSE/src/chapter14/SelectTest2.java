package chapter14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest2 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(" select * from emp ");
			rs = stmt.executeQuery();
			System.out.println("사원번호\t이름\t급여\t부서번호\t업무");
			while(rs.next()) {
				System.out.printf("%d\t%s\t%d\t%d\t%s\n", rs.getInt("empno"), rs.getString("ename"), rs.getInt("sal"), rs.getInt("deptno"), rs.getString("job"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

}
