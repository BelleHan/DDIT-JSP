package com.jsp.datasource;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

public class MockSqlSession implements SqlSession {

	@Override
	public void clearCache() {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void commit(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public int delete(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BatchResult> flushStatements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration getConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getMapper(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rollback(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void select(String arg0, ResultHandler arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void select(String arg0, Object arg1, ResultHandler arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void select(String arg0, Object arg1, RowBounds arg2, ResultHandler arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> Cursor<T> selectCursor(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Cursor<T> selectCursor(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Cursor<T> selectCursor(String arg0, Object arg1, RowBounds arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E> List<E> selectList(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E> List<E> selectList(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E> List<E> selectList(String arg0, Object arg1, RowBounds arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K, V> Map<K, V> selectMap(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K, V> Map<K, V> selectMap(String arg0, Object arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K, V> Map<K, V> selectMap(String arg0, Object arg1, String arg2, RowBounds arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T selectOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T selectOne(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

}
