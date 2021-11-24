package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.MemberVO;
import com.jsp.request.Criteria;
import com.jsp.request.SearchCriteria;

public interface MemberDAO {
   
   // 회원정보 조회
   MemberVO selectMemberById(SqlSession session, String id) throws SQLException;
   
   //회원리스트 조회
   List<MemberVO> selectMemberList(SqlSession session)throws SQLException;
   List<MemberVO> selectMemberList(SqlSession session,Criteria cri)throws SQLException;
   List<MemberVO> selectMemberList(SqlSession session,SearchCriteria cri)throws SQLException;
   
   // 검색결과의 전체 리스트 개수
   int selectMemberListCount(SqlSession session,SearchCriteria cri) throws SQLException;
   
   //회원추가
   public void insertMember(SqlSession session, MemberVO member) throws SQLException;
   
   //회원수정
   public void updateMember(SqlSession session, MemberVO member) throws SQLException;
   
   //회원정보삭제
   void deleteMember(SqlSession session, String id) throws SQLException;
   
   //회원정지
   void disableMember(SqlSession session, String id) throws SQLException;
   
   //회원 활성화
   void enableMember(SqlSession session, String id) throws SQLException;
   

}