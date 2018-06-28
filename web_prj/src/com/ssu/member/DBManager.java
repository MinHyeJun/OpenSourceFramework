package com.ssu.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	
	
	public Connection dbConn() {
		Connection conn = null;
		try {
			
			String url ="jdbc:oracle:thin:@127.0.0.1:1521:XE";
			conn = DriverManager.getConnection(url, "ssu", "0000");  //connection return
			
			if(conn != null)
				System.out.println("연결성공");
			else
				System.out.println("연결실패");
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		return conn;
	}

	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void dbClose(PreparedStatement pstmt, Connection conn) {
		try {
			
			if(pstmt !=null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
