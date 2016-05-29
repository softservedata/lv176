package com.softserve.edu.atqc.test;

import java.util.HashMap;

import org.testng.ITestContext;

import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.atqc.data.apps.ApplicationSources.ParameterList;

public final class ParameterUtils {
	private static volatile ParameterUtils instance = null;

	private ParameterUtils() {
	}

	public static ParameterUtils get() {
		if (instance == null) {
			synchronized (ParameterUtils.class) {
				if (instance == null) {
					instance = new ParameterUtils();
				}
			}
		}
		return instance;
	}

	public ApplicationSources updateSuiteApplicationSources(ApplicationSources applicationSources, ITestContext context) {
        HashMap<String, String> suiteParameters = new HashMap<String, String>(context.getCurrentXmlTest().getSuite().getParameters()); 
        for (String key : suiteParameters.keySet()) {
        	for (ParameterList field : ParameterList.values()) {
            	if (key.toLowerCase().contains(field.toString().toLowerCase())) {
            		field.setParameter(suiteParameters.get(key), applicationSources);
            		break;
            	}
        	}
        }
		return applicationSources;
	}

	public ApplicationSources updateTestApplicationSources(ApplicationSources applicationSources, ITestContext context) {
        HashMap<String, String> testParameters = new HashMap<String, String>(context.getCurrentXmlTest().getTestParameters()); 
        for (String key : testParameters.keySet()) {
        	for (ParameterList field : ParameterList.values()) {
            	if (key.toLowerCase().contains(field.toString().toLowerCase())) {
            		field.setParameter(testParameters.get(key), applicationSources);
            		break;
            	}
        	}
        }
		return applicationSources;
	}

	public ApplicationSources updateAllApplicationSources(ApplicationSources applicationSources, ITestContext context) {
		updateSuiteApplicationSources(applicationSources, context);
		updateTestApplicationSources(applicationSources, context);
		return applicationSources;
	}

}
