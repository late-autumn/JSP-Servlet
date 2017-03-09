package com.acorn.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.sql.DataSource;

//dbcp를 이용한 테이블 보드처리 데이터베이스 연동 자바빈즈 프로그램
public class BoardDBCP {

	//데이터베이스 연결 관련 변수 선언
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private DataSource ds = null;
	
	public BoardDBCP() {
		// TODO Auto-generated constructor stub
	
		try{
			InitialContext ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mydb");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void connect(){
		try{
			con = ds.getConnection();
			
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	public void disconnect(){
		if(pstmt != null){
			try{
				pstmt.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		if(con != null){
			try{
				con.close();
			}catch(SQLException se){
				se.printStackTrace();
				
			}
			
		}
		
	}
	//게시판의 모든 레코드를 반환 메서드
	public Vector<BoardEntity> getBoardList(){
		
		connect();//db 연결
		
		Vector<BoardEntity> list = new Vector<BoardEntity>();
		String SQL = "select no, name, password, title, email, regdate, content from board";
		
		try{
			pstmt = con.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				BoardEntity brd = new BoardEntity();
				brd.setNo(rs.getInt("no"));
				brd.setName(rs.getString("name"));
				brd.setPassword(rs.getString("password"));
				brd.setTitle(rs.getString("title"));
				brd.setEmail(rs.getString("email"));
				brd.setRegdate(rs.getTimestamp("regdate"));
				brd.setContent(rs.getString("content"));
				
				list.add(brd);
				
			}
			rs.close();
			
		}catch(SQLException se){
			se.printStackTrace();
		}
		finally{
			disconnect();
		}
		return list;
	}
	//주키 no의 레코드를 반환하는 메서드
	public BoardEntity getBoard(int no){
		
		connect();
		//디비 연결
		
		String SQL = "select no, name, password, title, email, regdate, content from board where no = ?";
		//조회쿼리 작성
		
		BoardEntity brd = new BoardEntity();
		//빈으로 해서 설정데이터를 가지고 온다
		
		try{
			pstmt = con.prepareStatement(SQL);
			
			pstmt.setInt(1, no);
			//주키 설정
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			brd.setNo(rs.getInt("no"));
			brd.setName(rs.getString("name"));
			brd.setPassword(rs.getString("password"));
			brd.setTitle(rs.getString("title"));
			brd.setEmail(rs.getString("email"));
			brd.setRegdate(rs.getTime("regdate"));
			brd.setContent(rs.getString("content"));
			
			rs.close();
		}catch(SQLException se){
			
			se.printStackTrace();
			
		}finally{
			
			disconnect();
			//디비 연결 해제
		
		}
		return brd;
	}//end search no method
	
	//게시물 등록 메서드
	public boolean insertDB(BoardEntity obj){
			
		boolean success = false;
		
		connect();
		
		String SQL = "insert into bodard(no, name, password, title, email, content) values(board_seq.nextval, ?, ?, ?, ?, ?)";
		
		try{
			
			pstmt = con.prepareStatement(SQL);
			
			pstmt.setString(1, obj.getName());
			pstmt.setString(2, obj.getPassword());
			pstmt.setString(3, obj.getTitle());
			pstmt.setString(4, obj.getEmail());
			pstmt.setString(5, obj.getContent());
			pstmt.executeUpdate();
			
			success = true;
			
			pstmt.close();
			
		}catch (SQLException se) {
			// TODO: handle exception
			
			se.printStackTrace();
			return success;
		}finally{
			disconnect();
		}
		return success;
	}//end insert method
	
	//수정하는 메서드
	public boolean update(BoardEntity board){
		
		boolean success = false;
		
		connect();
		
		String sql = "update board set name=?, title=?, email=?, content=? where no=?";
		
		try{
			pstmt = con.prepareStatement(sql);
			//인자로 받은 board 객체를 이용해서 사용자가 수정한 값을 가져다가 쿼리문 완성한다.
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getContent());
			pstmt.setInt(5, board.getNo());
			
			int rowUdt = pstmt.executeUpdate();
			System.out.println(rowUdt);
			
			if(rowUdt == 1){
				success = true;
			}
		}catch (SQLException se) {
			// TODO: handle exception
			se.printStackTrace();
			return success;
		}
		finally{
			disconnect();
		}
		return success;
		
		
	}
	
	//삭제하는 메서드
	public boolean delete(int no){
		
		boolean success = false;
		
		connect();
		
		String sql = "delete from board where no = ?";
		
		try{
			pstmt = con.prepareStatement(sql);
			//인자로 받은 주키인 no 값을 이용해서 삭제한다.
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
			success = true;
		}catch (SQLException se) {
			// TODO: handle exception
			se.printStackTrace();
			return success;
		}finally{
			disconnect();
			
		}
		return success;
	}
	
	
	//데이터베이스에서 인자인 no와 password가 일치하는지 확인하는 메서드
	public boolean isPassword(int no, String password){
		
		boolean flag = false;
		
		connect();
		
		String sql = "select password from board where no = ?";
		try{
			pstmt = con.prepareStatement(sql);
		
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			String orgPassword = rs.getString(1);
			
			if(password.equals(orgPassword)){
				flag = true;
			}
			System.out.println(flag);
			rs.close();
		}catch(SQLException se){
			se.printStackTrace();
			
			return flag;
		}finally {
			disconnect();
		}
		return flag;
	
	}

}
