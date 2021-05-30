package com.demo.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.demo.dao.LogProcessingDAO;

public class LogProcessingDAOImpl implements LogProcessingDAO {
	private static Logger log = LoggerFactory.getLogger(LogProcessingDAOImpl.class);

	public void insertEvent(String id, Long duration, String type, String host, Boolean alert) {

		// TODO: Connect to DataBase and Insert the data into database.

		System.out.println("Id= " + id + " Duration: " + duration + " Type: " + type + " host: " + host + " alret##:" + alert);
		log.debug("Id= " + id + " Duration: " + duration + " Type: " + type + " host: " + host + " alret##:" + alert);

		
	}

}
