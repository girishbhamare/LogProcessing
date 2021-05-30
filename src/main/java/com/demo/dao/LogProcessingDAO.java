package com.demo.dao;

public interface LogProcessingDAO {
	
	public void insertEvent(String id,Long duration,String type,String host,Boolean alert);

}
