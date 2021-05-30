package com.demo;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.service.LogProcessingService;
import com.demo.service.impl.LogProcessingServiceImpl;

public class Starter {

	private static Logger log = LoggerFactory.getLogger(Starter.class);

	public static void main(String[] args) throws IOException {
		LogProcessingService lps = new LogProcessingServiceImpl();

		log.info("Starting File Processing");
		lps.processLogFile("src/main/resources/logfile.txt");
		log.info("Finishing File Processing");

	}

}
