package com.softserve.edu.atqs.tools.loggers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.softserve.edu.atqc.tools.BrowserUtils;

public class CaptureScreenImage {
	private final String TIME_TEMPLATE = "yyyy_MM_dd HH-mm-ss";
	private final String FILE_SUFFIX = " CaptureScreenImage.png";
	private final String DEFAULT_DIRECTORY = "./test-output";
	private final String MAVEN_DIRECTORY = "surefire.reports.directory";
	private final String SLASH = "/";
	private static volatile CaptureScreenImage instance = null;

	private CaptureScreenImage() {
	}

	public static CaptureScreenImage get() {
		if (instance == null) {
			synchronized (CaptureScreenImage.class) {
				if (instance == null) {
					instance = new CaptureScreenImage();
				}
			}
		}
		return instance;
	}

	private String getCurrentTime() {
		return new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
	}

	private String getOutputDirectory() {
		String outputDirectory = System.getProperty(MAVEN_DIRECTORY);
		if ((outputDirectory == null) || (outputDirectory.isEmpty())) {
			outputDirectory = DEFAULT_DIRECTORY;
		}
		return outputDirectory + SLASH;
	}

	private String getAbsolutePathFileName() {
		return getOutputDirectory() + getCurrentTime() + FILE_SUFFIX;
	}

	public String captureAndSaveScreen() {
		String absolutePathFileName = getAbsolutePathFileName();
		try {
			File srcFile = ((TakesScreenshot) BrowserUtils.get().getBrowser().getWebDriver())
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(absolutePathFileName));
		} catch (Exception e) {
			Log4jWrapper.get().info("Some problem with srcFile");
		}
		return absolutePathFileName;
	}
}
