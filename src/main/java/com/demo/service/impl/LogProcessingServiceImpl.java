package com.demo.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.demo.dao.LogProcessingDAO;
import com.demo.dao.impl.LogProcessingDAOImpl;
import com.demo.model.Event;
import com.demo.service.LogProcessingService;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LogProcessingServiceImpl implements LogProcessingService {
	private static Logger log = LoggerFactory.getLogger(LogProcessingServiceImpl.class);
	LogProcessingDAO lpd = new LogProcessingDAOImpl();

	public Map<String, List<Event>> fetchEventFromFile(String filePath) {
		long diff = -1;
		Map<String, List<Event>> map = new HashMap<>();
		BufferedReader br = null;

		try {

			log.debug("Create File Object");
			File file = new File(filePath);
			br = new BufferedReader(new FileReader(file));

			String line = null;
			ObjectMapper objectMapper = new ObjectMapper();

			log.debug("Read file line by line");
			while ((line = br.readLine()) != null) {
				log.debug(line);
				Event e = objectMapper.readValue(line, Event.class);

				if (map.containsKey(e.getId())) {

					if ((map.get(e.getId()).get(0)).getState() == Event.State.STARTED) {
						diff = e.getTimestamp() - (map.get(e.getId()).get(0)).getTimestamp();

					} else {

						diff = (map.get(e.getId()).get(0)).getTimestamp() - e.getTimestamp();

					}

					log.debug("This is for inserting entry into database");
					this.lpd.insertEvent(e.getId(), diff, e.getType(), e.getHost(), diff > 4 ? true : false);
					map.remove(e.getId()); // to save memory
				} else {
					List<Event> events = new ArrayList<Event>();
					events.add(e);
					map.put(e.getId(), events);
				}

			}

		} catch (Exception e) {
			log.error("Failure reading the file", e);
			e.printStackTrace();
		} finally {

			// Always close the BufferedReader
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
				}
				;
			}
		}
		return map;

	}

	@Override
	public void processLogFile(String filePath) throws IOException {
		log.info("Processing filepath : " + filePath);
		if (filePath.isEmpty()) {
			throw new InvalidParameterException("Please provide valid log.txt file");
		} else if (!filePath.contains("src/main/resources/logfile.txt")) {
			throw new FileNotFoundException(filePath);
		}
		fetchEventFromFile(filePath);

	}
	
	

}
