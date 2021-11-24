package com.jsp.datasource;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MemberVO;

public class TestOracleMybatisSqlSessionFactory {
	
	private SqlSessionFactory sqlSessionFactory = new OracleMybatisSqlSessionFactory();
	private SqlSession session;
	
	@Before
	public void init() {
		session = sqlSessionFactory.openSession();

	}

	@Test
	public void testNotNullSession() {
		Assert.assertNotNull(session);
	}
	
	@Test
	public void testNotNullConnection() {
		Assert.assertNotNull(session.getConnection());
	}
	
	@Test
	public void testSQL() throws SQLException{
		
		String testID = "mimi";
		
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById", testID);
		
		Assert.assertEquals(testID, member.getId());
		
	}
	
	@After
	public void complete() {
		session.close();
	}

}
