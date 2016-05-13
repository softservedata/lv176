package com.softserve.edu.rs.data.apps;

import com.softserve.edu.atqc.data.apps.ABaseApplication;
import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.rs.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public final class Application extends ABaseApplication<LoginPage> { 
    //змінила на паблік
	public Application(ApplicationSources applicationSources) {
		super(applicationSources);
    }

    public static Application get(ApplicationSources applicationSources) {
        return new Application(applicationSources);
    }

     //змінила protrected на паблік
	public LoginPage getStartPage() {
		return new LoginPage();
	}

//    	public void addEventsPageLoadComplete() {
//            PageObserveLoad.get().addLoadCompleteEvent(new PageLoadComplete());
//            //PageObserveLoad.get().addLoadCompleteEvent(new PageLoadComplete2());
//        }
//
//        public void clearEventsPageLoadComplete() {
//            PageObserveLoad.get().deleteLoadCompleteEvents();
//        }

    }
