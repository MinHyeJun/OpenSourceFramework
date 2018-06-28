package com.ssu.member;
import java.sql.*;

public class JDBCTest {

	public static void main(String[] args) {
	
			Member m = new Member();
			//m.memberInsert("hong", "444", "홍씨");
			//m.memberUpdate("kong", "hong");
			//m.memberDelete("kong");
			m.memberList();
		
		}
	}

