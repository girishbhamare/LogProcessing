package com.demo;

import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.service.LogProcessingService;
import com.demo.service.impl.LogProcessingServiceImpl;

public class Starter {

	private static Logger log = LoggerFactory.getLogger(Starter.class);

	public static void main(String[] args) throws IOException {
		LogProcessingService lps = new LogProcessingServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("--Enter Vaild File Path--");
		String filePath = sc.nextLine();

		log.info("Starting File Processing " + filePath);

		lps.processLogFile(filePath);
		log.info("Finishing File Processing");

	}

}
