package com.jsp.datasource;

import java.sql.Connection;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;

public class MockSqlSessionFactory implements SqlSessionFactory{

	@Override
	public Configuration getConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SqlSession openSession() {
		return new MockSqlSession();
	}

	@Override
	public SqlSession openSession(boolean arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SqlSession openSession(Connection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SqlSession openSession(TransactionIsolationLevel arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SqlSession openSession(ExecutorType arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SqlSession openSession(ExecutorType arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SqlSession openSession(ExecutorType arg0, TransactionIsolationLevel arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SqlSession openSession(ExecutorType arg0, Connection arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
