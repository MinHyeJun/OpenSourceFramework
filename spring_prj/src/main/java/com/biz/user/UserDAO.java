package com.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; 
	
	public UserVO getUser(UserVO vo) {
		try {
			conn = DBManager.getConnection();
			String sql = "select mname from member where mid=? and mpw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setMname(rs.getString("mname"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return vo;
	}
}
