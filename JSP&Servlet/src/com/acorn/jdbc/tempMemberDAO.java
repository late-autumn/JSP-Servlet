package com.acorn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class tempMemberDAO {

	/*private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String USER = "scott";
	private String PASSWORD = "tiger";
	*/
	private ConnectionPool pool;
	
	public tempMemberDAO() {
		// TODO Auto-generated constructor stub
	
		
		try{
			
			//Class.forName(JDBC_DRIVER);
			
			pool = ConnectionPool.getInstance();
			//커넥션 풀을 이용
		}catch(Exception e){
		//	System.out.println("ERROR : JDBC driver loading failed");
			System.out.println("error : connection pool failed");
		}
		
	}
	public Vector<tempMemberVO> getMemberList(){
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Vector<tempMemberVO> veclist = new Vector<tempMemberVO>();
		
		try{
			//conn = DriverManager.getConnection(JDBC_URL,USER, PASSWORD);
			conn = pool.getConnection();
			String strQuery = "select * from tempMember";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(strQuery);
			while(rs.next()){
				
				tempMemberVO vo = new tempMemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setMem_num1(rs.getString("mem_num1"));
				vo.setMem_num2(rs.getString("mem_num2"));
				vo.setEmail(rs.getString("e_mail"));
				vo.setPhone(rs.getString("phone"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress(rs.getString("address"));
				vo.setJob(rs.getString("job"));
				veclist.add(vo);
				
			}//end while
			
		}catch(Exception e){
			System.out.println("exception"+e);
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch (SQLException se) {
					// TODO: handle exception
					se.printStackTrace();
				}
			}
			if(stmt != null){
				try{
					stmt.close();
				}catch (SQLException se) {
					// TODO: handle exception
					se.printStackTrace();
				}
			}
			if(conn != null){
				try{
					//conn.close();
					pool.releaseConnection(conn);
				}catch (SQLException se) {
					// TODO: handle exception
					se.printStackTrace();
				}
			}
			return veclist;
		}
	}
	
}
