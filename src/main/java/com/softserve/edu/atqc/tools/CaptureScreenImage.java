package com.softserve.edu.atqc.tools;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.softserve.edu.atqc.data.apps.PageObserveLoad;
import com.softserve.edu.atqc.exceptions.GeneralCustomException;

public class CaptureScreenImage {
    private final String TIME_TEMPLATE = "yyyy_MM_dd HH-mm-ss";
    private final String FILE_SUFFIX = " CaptureScreenImage.png";
    private final String DEFAULT_DIRECTORY = "./test-output";
    private final String MAVEN_DIRECTORY = "surefire.reports.directory";
    private final String SLASH = "/";
    private final String FAILED_TO_CREATE = "Failed to create screenshot: %s";
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
            if (PageObserveLoad.get().isLoadComplete()) {
                File srcFile = ((TakesScreenshot) BrowserUtils.get()
                        .getBrowser().getWebDriver()).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFile, new File(absolutePathFileName));
            }
		} catch (Exception e) {
			throw new GeneralCustomException(String.format(FAILED_TO_CREATE,
					absolutePathFileName), e);
		}
		return absolutePathFileName;
	}
}
