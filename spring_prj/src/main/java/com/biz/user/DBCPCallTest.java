package com.biz.user;

import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.apache.ibatis.io.Resources;

public class DBCPCallTest {
	public static void main(String[] args) {
		
		//spring에 붙였을 때의 path
		String path = "D:\\accord\\workspace\\spring_prj\\src\\main\\webapp\\WEB-INF\\servlet-context.xml";
		Resource src = new FileSystemResource(path);
		BeanFactory ft = new XmlBeanFactory(src);
		DataSource ds = (DataSource)ft.getBean("datasoc");
		Connection conn = null;
		try {
			conn = ds.getConnection();
			if(conn == null)
				System.out.println("fail");
			else
				System.out.println("ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
//		//Mybatis을 단독으로 쓸 때 path
//		//Mybatis session build
//		String path2 = "mybatis-context.xml";
//		Reader reader; 
//		try {
//			reader = Resources.getResourceAsReader(path2);
//			SqlSessionFactory dbManager  
//			= new SqlSessionFactoryBuilder().build(reader);
//			if(dbManager == null)
//				System.out.println("err");
//			else
//				System.out.println("ok");
//			
//			SqlSession conn 
//			= dbManager.openSession();
			
			//conn.delete(arg0, arg1)
			//conn.insert(arg0, arg1)
			//conn.update(arg0, arg1)
			//conn.selectList(arg0, arg1)
			//conn.selectOne(arg0, arg1)
			//conn.select(arg0, arg1, arg2, arg3)
			//conn.select(arg0, arg1, arg2, arg3)
			MemberVO vo = new MemberVO();
			
			
//			vo.setId("lkh");
//			vo.setPw("0000"); 
//			vo = conn.selectOne("userNameSpace.login", vo);
//			System.out.println(vo.getSeq());
			
//			vo.setMid("user2");
//			vo.setMpw("999");
//			Integer res = conn.insert("userNameSpace.meminsert", vo);
//			conn.commit();
//			System.out.println("RES:" + res);
//			
////			vo.setPw("999");
////			vo.setId("lkh");
////			int ur = conn.update("userNameSpace.memUpdate", vo);
////			conn.commit();
////			System.out.println("upt건수" + ur);
//			
////			vo.setSeq(3);
////			conn.delete("userNameSpace.memDelete", vo);
////			conn.commit();
////			
//			System.out.println("\n\n----------------------");
//			ArrayList<MemberVO> list = (ArrayList)conn.selectList("userNameSpace.allUser");
//			for(int i=0; i<list.size(); i++) {
//				vo = list.get(i);
//				System.out.println(vo.getMid() + "," + vo.getSeq());
//			}
//			
////			ArrayList list 
////			= (ArrayList)session.selectOne
////			("userNameSpace.login");
////			System.out.println(list.size());
////			session.close();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//				
//				
////				session = sqlSessionFactory.openSession();
////				vo.setUserid("admin");
////				vo.setUserpw("1111");
////				list = (ArrayList) session.select("userNameSpace.login", vo);	
//					
//		
	}
	
}