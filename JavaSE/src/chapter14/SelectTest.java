package chapter14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
		String id = "ssafy";
		String pw = "ssafy";
		try {
			//1. Driver loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. DB 연결
			con = DriverManager.getConnection(url, id, pw);
			//3. query 수행을 위한 statement 생성
			stmt = con.prepareStatement(" select * from emp ");
			//4. query 수행
			rs = stmt.executeQuery();
			System.out.println("사원번호\t이름\t급여\t부서번호\t업무");
			//5. 결과 처리 next() : 다음행이 있으면 커서를 이동시키고 없으면 false
			while(rs.next()) {
				System.out.printf("%d\t%s\t%d\t%d\t%s\n", rs.getInt("empno"), rs.getString("ename"), rs.getInt("sal"), rs.getInt("deptno"), rs.getString("job"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(con!=null)try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
