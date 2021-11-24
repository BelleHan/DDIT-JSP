package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.dto.NoticeVO;
import com.jsp.request.SearchCriteria;

public class NoticeDAOImpl implements NoticeDAO {

	@Override
	public List<NoticeVO> selectSearchNoticeList(SqlSession session, SearchCriteria cri) throws SQLException {
		
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();		
		RowBounds rowBounds=new RowBounds(offset,limit);		
		
		List<NoticeVO> noticeList=
				session.selectList("Notice-Mapper.selectSearchNoticeList",cri,rowBounds);
		
		return noticeList;
	}

	@Override
	public int selectSearchNoticeListCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count=session.selectOne("Notice-Mapper.selectSearchNoticeListCount",cri);
		return count;
	}

	@Override
	public NoticeVO selectNoticeByNno(SqlSession session, int nno) throws SQLException {
		NoticeVO notice=session.selectOne("Notice-Mapper.selectNoticeByNno",nno);
		return notice;
	}

	@Override
	public void increaseViewCount(SqlSession session, int nno) throws SQLException {
		session.update("Notice-Mapper.increaseViewCount",nno);
		
	}

	@Override
	public int selectNoticeSequenceNextValue(SqlSession session) throws SQLException {
		int seq_num=session.selectOne("Notice-Mapper.selectNoticeSequenceNextValue");
		return seq_num;
	}

	@Override
	public void insertNotice(SqlSession session, NoticeVO notice) throws SQLException {
		session.update("Notice-Mapper.insertNotice",notice);
		
	}
	
	@Override
	public void updateNotice(SqlSession session,NoticeVO notice) throws SQLException {
		session.update("Notice-Mapper.updateNotice",notice);
	}

	@Override
	public void deleteNotice(SqlSession session,int nno) throws SQLException {
		session.update("Notice-Mapper.deleteNotice",nno);
	}
}











