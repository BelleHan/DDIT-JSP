package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.MemberDAO;
import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.request.Criteria;
import com.jsp.request.PageMaker;
import com.jsp.request.SearchCriteria;

public class MemberServiceImpl implements MemberService {

   private SqlSessionFactory sqlSessionFactory;

   public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
      this.sqlSessionFactory = sqlSessionFactory;
   }

   private MemberDAO memberDAO;

   public void setMemberDAO(MemberDAO memberDAO) {
      this.memberDAO = memberDAO;
   }

   @Override
   public void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException {

      SqlSession session = sqlSessionFactory.openSession();
      try {

         MemberVO member = memberDAO.selectMemberById(session, id);
         if (member == null)
            throw new NotFoundIDException();
         if (!pwd.equals(member.getPwd()))
            throw new InvalidPasswordException();

      } finally {
         session.close();
      }
   }

   @Override
   public List<MemberVO> getMemberList() throws SQLException {
      SqlSession session = sqlSessionFactory.openSession();
      try {
         List<MemberVO> memberList = memberDAO.selectMemberList(session);
         return memberList;
      } finally {
         session.close();
      }

   }

   @Override
   public MemberVO getMember(String id) throws SQLException {
      SqlSession session = sqlSessionFactory.openSession();
      try {
         MemberVO member = memberDAO.selectMemberById(session, id);
         return member;
      } finally {
         session.close();
      }
   }

   @Override
   public void regist(MemberVO member) throws SQLException {
      SqlSession session = sqlSessionFactory.openSession();
      try {

         memberDAO.insertMember(session, member);
      } finally {
         session.close();
      }
   }

   @Override
   public void modify(MemberVO member) throws SQLException {
      SqlSession session = sqlSessionFactory.openSession();
      try {
         memberDAO.updateMember(session, member);
      } finally {
         session.close();
      }
   }

   @Override
   public void remove(String id) throws SQLException {
      SqlSession session = sqlSessionFactory.openSession();
      try {

         memberDAO.deleteMember(session, id);
      } finally {
         session.close();
      }
   }

   @Override
   public void disabled(String id) throws SQLException {
      SqlSession session = sqlSessionFactory.openSession();
      try {

         memberDAO.disableMember(session, id);
      } finally {
         session.close();
      }
   }

   @Override
   public void enabled(String id) throws SQLException {
      SqlSession session = sqlSessionFactory.openSession();
      try {

         memberDAO.enableMember(session, id);
      } finally {
         session.close();
      }
   }

	@Override
	public List<MemberVO> getMemberList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<MemberVO> memberList = memberDAO.selectMemberList(session,cri);
			return memberList;
		} finally {
			session.close();
		}
	}

	@Override
	public Map<String, Object> getMemberList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		try {
			List<MemberVO> memberList = memberDAO.selectMemberList(session, cri);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(memberDAO.selectMemberListCount(session, cri));
			
			
			dataMap.put("memberList", memberList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
			
		} finally {
			session.close();
		}
	}

}