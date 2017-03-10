package com.acorn.jdbc;

import java.sql.*;
import java.util.*;

public class ConnectionPool {

	static {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}
	}
	
	private ArrayList<Connection> free;
	//사용하지 않은 커넥션 즉, 초기 커넥션을 저장하는 변수
	private ArrayList<Connection> used;
	//사용중인 커넥션을 저장하는 변수
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String user = "scott";
	private String password = "tiger";
	//커넥션 설정
	private int initalCons = 10;
	//최초로 연결된 초기 커넥션 수
	private int maxCons = 20;
	//최대 연결 가능한 커넥션 수
	private int numCons = 0;
	//총 커넥션 수 
	private static ConnectionPool cp;
	
	public static ConnectionPool getInstance(){
		
		try{
			if(cp == null){
				synchronized (ConnectionPool.class) {
					cp = new ConnectionPool();
				}
			}
		}catch (SQLException se) {
			// TODO: handle exception
			se.printStackTrace();
		}
		return cp;
	}
	private ConnectionPool() throws SQLException{
		//초기 커넥션 개수를 각가의 arraylist에 저장할 수 있도록 초기 커넥션 수만큼 arraylist생성
		free = new ArrayList<Connection>(initalCons);
		used = new ArrayList<Connection>(initalCons);
		
		//initialCons 수만큼 Connection 생성(free)
		while(numCons < initalCons){
			addConnection();
		}
	}
	//free에 커넥션 객체를 저장한다
	private void addConnection() throws SQLException{
		free.add(getNewConnection());
	}
	
	//새로운 커넥션 객체를 생성한다
	private Connection getNewConnection() throws SQLException{
		Connection con = null;
		try{
			con = DriverManager.getConnection(url, user, password);
		}catch (SQLException se) {
			// TODO: handle exception
			se.printStackTrace();
		}
		++numCons;
		//커넥션 생서될 때 마다 숫자 증가
		return con;
	}
	//free에 있는 커넥션을 used로 옮기는 작업 => free--->used
	public synchronized Connection getConnection() throws SQLException{
		//free에 connection이 없으면 maxCons만큼 Connection을 더 생성한다
		if(free.isEmpty()){
			while(numCons < maxCons){
				addConnection();
			}
		}
		Connection _con;
		_con = free.get(free.size()-1);
		free.remove(_con);
		return _con;
	}
	//used에 있는 커넥션을 free로 반환한다
	public void releaseConnection(Connection _con) throws SQLException{
		
		boolean flag = false;
		if(used.contains(_con)){
			used.remove(_con);
			numCons--;
			flag = true;
			
		}else{
			throw new SQLException("ConnectionPool"+"에 있지 않네요 ");
		}
		try{
			if(flag){
				free.add(_con);
				numCons++;
			}else{
				_con.close();
			}
		}catch(SQLException se){
			try{
				_con.close();
			}catch(SQLException see){
				see.printStackTrace();
			}
		}
	}
	//모든 커넥션 자원을 반납한다
	
	public void closeAll(){
		//used에 있는 커넥션을 모두 삭제한다
		for(int i = 0; i < free.size(); i++){
			Connection _con = (Connection)free.get(i);
			used.remove(i--);
			
			try{
				_con.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	
	}	//free에 있는 커넥션을 모두 삭제해 버린다.
	public int getMaxCons() {
		return maxCons;
	}
	public int getNumCons() {
		return numCons;
	}
	
}
