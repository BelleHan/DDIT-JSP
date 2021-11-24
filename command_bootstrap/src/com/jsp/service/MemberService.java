package com.jsp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIDException;
import com.jsp.request.Criteria;
import com.jsp.request.SearchCriteria;

public interface MemberService {

   
   // 로그인
   void login(String id, String pwd) throws SQLException, NotFoundIDException, 
                                                InvalidPasswordException;
   
   // 회원정보조회
   MemberVO getMember(String id) throws SQLException;
   
   // 회원리스트조회
   List<MemberVO> getMemberList() throws SQLException;
   List<MemberVO> getMemberList(Criteria cri) throws SQLException;
   Map<String,Object> getMemberList(SearchCriteria cri) throws SQLException;
   
   // 회원등록
   public void regist(MemberVO member) throws SQLException;
   
   // 회원수정
   void modify(MemberVO member) throws SQLException;
   
   // 회원삭제
   void remove(String id) throws SQLException;
   
   // 회원정지
   void disabled(String id) throws SQLException;
   
   // 회원활성
   void enabled(String id) throws SQLException;
   
}