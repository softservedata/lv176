package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.Link;

public class ProcurationPage extends EnteringData{
	private class ProcurationPageUIMap {

		public final ILabel pdfViewer;

		public ProcurationPageUIMap() {
			this.pdfViewer = Link.get().getByXpath("//*[@id='toolbar']");
		}

	}
	
	private ProcurationPageUIMap controls;

	public ProcurationPage() {
		this.controls = new ProcurationPageUIMap();
	}
	
	public boolean getProcuration(){
		return CommonPage.getStatus();
	}

	// get elements
	public boolean getpdfViewer() {
		this.controls.pdfViewer.isEnabled();
		return CommonPage.getStatus();
	}

}
