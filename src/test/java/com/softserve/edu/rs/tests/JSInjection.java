package com.softserve.edu.rs.tests;

import org.openqa.selenium.JavascriptExecutor;

import com.softserve.edu.atqc.tools.Coordinate;
import com.softserve.edu.rs.pages.ResourceSearchPage;

public class JSInjection {
	static void executeClickMap(ResourceSearchPage spage, Coordinate latitude, Coordinate longitude) {
		JavascriptExecutor js = (JavascriptExecutor) spage.getJsExecutor();
		js.executeScript("var myCenter=new google.maps.LatLng(" + latitude.toString() + "," + longitude.toString()
				+ ");" + "var marker=new google.maps.Marker({ position:myCenter,});"
				+ "marker.setMap(map);  map.setCenter(myCenter); " + "map.setZoom(9);" + " searchOnMapByPoint(marker)");
	}
}
