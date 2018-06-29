package com.biz.user;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biz.user.DBManager;
import com.biz.user.MemberVO;

//@Repository // 디비 저장소를 드나드는 객체
public class MemberDAO {
//	@Autowired
	private SqlSession session;
	
	public MemberDAO(SqlSession session)
	{
		this.session = session;
	}
	
	public MemberVO memberLogin(MemberVO vo) {
		//member-map의 login을 호출
		return session.selectOne("memberNameSpace.login", vo);
	}
	
	public ArrayList memberList() {
		return (ArrayList)session.selectList("memberNameSpace.allMember");
	}
	
	public void memberInsert(MemberVO vo) {
	//(String mid, String mpw, String mname) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		//ResultSet rs = null;
		DBManager db = new DBManager();
		
		try {
			
			conn=db.dbConn();
			
		String insSql = "insert into member values(member_seq.nextval,?,?,?,'u',sysdate)";// ? = 뭐가 들어올지 모름
		pstmt = conn.prepareStatement(insSql);
		//바인딩 (물음표에 값 넣어주기)
		pstmt.setString(1, vo.getMid());
		pstmt.setString(2, vo.getMpw());
		pstmt.setString(3, vo.getMname());
		int rows = pstmt.executeUpdate(); // rows의 변경값 
		System.out.println(rows + "건 입력");
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
				db.dbClose(pstmt,conn);
		}
	}
	
	public void memberUpdate(String newmid, String oldmid) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		DBManager db = new DBManager();
		
		try {
			conn = db.dbConn();
						
			String UpSql = "update member set mid=? where mid=?";
			pstmt = conn.prepareStatement(UpSql);
			//바인딩
			pstmt.setString(1, newmid);
			pstmt.setString(2, oldmid);
			int up=pstmt.executeUpdate();
			System.out.println(up+"건 업데이트");
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
				db.dbClose(pstmt,conn);
		}

		
		
		
	}
	
	public void memberDelete(String mid) {
		
		Connection conn =null;
		PreparedStatement pstmt=null;
		//ResultStet rs = null;
		DBManager db = new DBManager();
		
		try {
			
			conn=db.dbConn();
			
			String delSql="delete from member where mid=?";
			pstmt=conn.prepareStatement(delSql);
			pstmt.setString(1, mid);
			int del = pstmt.executeUpdate();
			System.out.println(del+"건 삭제");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
		
	}

	
	
//	private Connection conn;
//	private PreparedStatement pstmt;
//	private ResultSet rs; 
//	
//	public UserVO getUser(UserVO vo) {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "select mname from member where mid=? and mpw=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getMid());
//			pstmt.setString(2, vo.getMpw());
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				vo.setMname(rs.getString("mname"));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(rs, pstmt, conn);
//		}
//		return vo;
//	}
}
