package com.softserve.edu.atqc.data.apps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.softserve.edu.atqc.exceptions.GeneralCustomException;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.atqc.tools.ControlSearch;

public class PageObserveLoad {
	// TODO Develop class for ONE_SECOND, sleep(), etc.
	public static final long ONE_SECOND = 1000L;
    public static final String ERROR_LOAD_FAILED = "Web Page Load Failed. Url is %s";
    //
    private static volatile PageObserveLoad instance = null;
    private final HashMap<Long, List<IObserveLoad>> observeLoad;
    private long observeLoadWaitTimeout = 30L;

    private PageObserveLoad() {
        this.observeLoad = new HashMap<Long, List<IObserveLoad>>(); 
    }

    public static PageObserveLoad get() {
        if (instance == null) {
            synchronized (ControlSearch.class) {
                if (instance == null) {
                    instance = new PageObserveLoad();
                }
            }
        }
        return instance;
    }
    
    public long getObserveLoadWaitTimeout() {
    	return this.observeLoadWaitTimeout;
    }

    public void setObserveLoadWaitTimeout(long observeLoadWaitTimeout) {
    	this.observeLoadWaitTimeout = observeLoadWaitTimeout;
    }

    private List<IObserveLoad> getCurrentEvents() {
        List<IObserveLoad> currentEvents = this.observeLoad.get(Thread.currentThread().getId());
        if (currentEvents == null) {
            currentEvents = new ArrayList<IObserveLoad>();
            this.observeLoad.put(Thread.currentThread().getId(), currentEvents);
        }
        return currentEvents;
    }

    public void addLoadCompleteEvent(IObserveLoad observeLoad){
        getCurrentEvents().add(observeLoad);
    }

    public void deleteLoadCompleteEvents(){
        getCurrentEvents().clear();
    }

    public void refreshLoadCompleteEvent(IObserveLoad observeLoad){
    	deleteLoadCompleteEvents();
    	addLoadCompleteEvent(observeLoad);
    }

    // If all Events Done
    public boolean isLoadComplete() {
        int countCompleteEvents = 0;
        long beginTime;
        boolean eventDone = false;
        for (IObserveLoad currentObserveLoad : getCurrentEvents()) {
            beginTime = System.currentTimeMillis();
            eventDone = false;
            while (System.currentTimeMillis() - beginTime < ONE_SECOND
                    * getObserveLoadWaitTimeout()) {
                if (currentObserveLoad.loadComplete()) {
                	countCompleteEvents++;
                    eventDone = true;
                    break;
                }
                try {
                    Thread.sleep(ONE_SECOND / 2);
                } catch (Exception e) {
                	// TODO Change Exception
                    throw new GeneralCustomException(String.format(PageObserveLoad.ERROR_LOAD_FAILED,
                            BrowserUtils.get().getBrowser().getCurrentUrl()));
                }
            }
            // TODO USe Strategy
            if (!eventDone) {
                throw new GeneralCustomException(String.format(PageObserveLoad.ERROR_LOAD_FAILED,
                        BrowserUtils.get().getBrowser().getCurrentUrl()));
            }
        }
        if (countCompleteEvents !=  getCurrentEvents().size()) {
            throw new GeneralCustomException(String.format(PageObserveLoad.ERROR_LOAD_FAILED,
                    BrowserUtils.get().getBrowser().getCurrentUrl()));
        }
        // TODO
        //return countCompleteEvents == getCurrentEvents().size();
        return true;
    }

}
