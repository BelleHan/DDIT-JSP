package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.dao.MenuDAO;
import com.jsp.dao.MenuDAOImpl;
import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MenuVO;


public class TestMenuDAOImpl {
	private SqlSessionFactory sqlSessionFactory = new OracleMybatisSqlSessionFactory();
	private SqlSession session;
	private MenuDAO menuDAO;
	
	@Before
	public void init() {
		session = sqlSessionFactory.openSession(false);
		menuDAO = new MenuDAOImpl();
	}
	
	  @Test
	  public void selectMainMenu() throws SQLException{
	     List<MenuVO> menuList = menuDAO.selectMainMenu(session);
	     int cnt = 5;
	     Assert.assertEquals(cnt, menuList.size());
	
	  }

	
	  @Test
	   public void selectSubMenu() throws SQLException{
	      String mCode = "M010000";
	      List<MenuVO> subMenu = menuDAO.selectSubMenu(session, mCode);
	      MenuVO menu = new MenuVO();
	      for (int i = 0; i < subMenu.size(); i++) {
	         menu = subMenu.get(i);
	      }
	      Assert.assertEquals(mCode, menu.getUpcode());
	   }

	
	@Test
	public void selectMenuByMcode() throws SQLException{
		String mCode = "M010000";
		
		MenuVO menu = menuDAO.selectMenuByMcode(session, mCode);
		
		Assert.assertEquals(mCode, menu.getMcode());
	}
	
	@Test
	public void selectMenuByMname() throws SQLException{
		String mName = "회원관리";
		
		MenuVO menu = menuDAO.selectMenuByMname(session, mName);
		
		Assert.assertEquals(mName, menu.getMname());
	}
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
}
