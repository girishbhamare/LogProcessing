package com.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.demo.model.Event;

public interface LogProcessingService  {

	public Map<String, List<Event>> fetchEventFromFile(String filePath);
	public void processLogFile(String filePath)throws IOException;	

}
