package com.demo.unittest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.demo.service.impl.LogProcessingServiceImpl;

@RunWith(JUnit4.class)
public class AllUnitTests {
	LogProcessingServiceImpl lpsRunner = new LogProcessingServiceImpl();

	@Before
	public void setup() {
		//Setup if required.
	}

	@Test
	public void testRun_ValidFile() throws IOException {
		String validFile = "src/main/resources/logfile.txt";
		lpsRunner.processLogFile(validFile);
	}

	@Test(expected = InvalidParameterException.class)
	public void testRun_EmptyFile() throws IOException {

		String emptyFilePath = "";
		lpsRunner.processLogFile(emptyFilePath);
	}

	@Test(expected = FileNotFoundException.class)
	public void testRun_InvalidFilePath() throws IOException {
		String inValidPath = "src/main/inValidFilePath.txt";
		lpsRunner.processLogFile(inValidPath);

	}

}
