package com.softserve.edu.atqc.tools;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.atqc.data.apps.PageObserveLoad;

public class ControlSearch {
	private final String EXPLICIT = "explicit";
	private final String IMPLICIT = "implicit";
	//
    private static volatile ControlSearch instance = null;
    private ASearchContext context;

    private ControlSearch() {
        // Set Strategy by Default.
    	//this.context = ContextRepository.get().getSearchDefault();
        //this.context = ContextRepository.get().getSearchExplicit();
        //this.context = ContextRepository.get().getSearchImplicit();
    }

	public static ControlSearch get() {
		return get(null); 
	}

    public static ControlSearch get(ApplicationSources applicationSources) {
        if (instance == null) {
            synchronized (ControlSearch.class) {
                if (instance == null) {
                    instance = new ControlSearch();
                }
            }
        }
        instance.checkStatus(applicationSources);
        return instance;
    }

	private void checkStatus(ApplicationSources applicationSources) {
		/*-
				AS		searchStrategy		context	Action
				+		+					+/-		set (check, else default)
		 *		+		-					+		-
		 *		+		-					-		defaul
		 *		-		-					+		-
		 *		-		-					-		defaul
		 */		
		if ((applicationSources != null)
				&& (applicationSources.getSearchStrategy() != null)
				&& !applicationSources.getSearchStrategy().isEmpty()) {
			if (applicationSources.getSearchStrategy().toLowerCase().contains(EXPLICIT)) {
				setExplicitStrategy(applicationSources.getExplicitTimeOut());
			} else if (applicationSources.getSearchStrategy().toLowerCase().contains(IMPLICIT)) {
				setImplicitStrategy(applicationSources.getImplicitTimeOut());
			} else {
				setContext(ContextRepository.get().getSearchDefault());
			}
		} else {
			if (getContext() == null) {
				setContext(ContextRepository.get().getSearchDefault());
			}
		}
	}
	
	private ASearchContext getContext() {
		return this.context;
	}
	
    // Set Strategy.
    ControlSearch setContext(ASearchContext context) {
        synchronized (ControlSearch.class) {
            this.context = context;
        }
        return this;
    }

    public ControlSearch setImplicitStrategy() {
        return setContext(ContextRepository.get().getSearchImplicit());
    }

    public ControlSearch setImplicitStrategy(long implicitlyWaitTimeout) {
    	ASearchContext searchImplicit = ContextRepository.get().getSearchImplicit();
    	searchImplicit.setWaitTimeout(implicitlyWaitTimeout);
        return setContext(searchImplicit);
    }

    public ControlSearch setExplicitStrategy() {
        return setContext(ContextRepository.get().getSearchExplicit());
    }

    public ControlSearch setExplicitStrategy(long explicitlyWaitTimeout) {
    	ASearchContext searchExplicit = ContextRepository.get().getSearchExplicit(); 
    	searchExplicit.setWaitTimeout(explicitlyWaitTimeout);
        return setContext(searchExplicit);
    }

    // TODO
    private boolean isLoadComplete() {
        //return true;
    	// TODO Sleep for Demo
    	//Thread.sleep(500);
        return PageObserveLoad.get().isLoadComplete();
    }
    
    /**
     * An expectation for checking that an element is present on the DOM of a
     * page and visible.
     */
    WebElement getVisibleWebElement(ControlLocation controlLocation) {
        isLoadComplete();
        return context.getVisibleWebElement(controlLocation);
    }

    /**
     * An expectation for checking that all elements present on the web page
     * that match the locator are visible.
     */
    List<WebElement> getVisibleWebElements(ControlLocation controlLocation) {
        isLoadComplete();
        return context.getVisibleWebElements(controlLocation);
    }

    /**
     * An expectation for checking that an element is present on the DOM of a
     * page. This does not necessarily mean that the element is visible.
     */
    WebElement getPresentWebElement(ControlLocation controlLocation) {
        isLoadComplete();
        return context.getPresentWebElement(controlLocation);
    }

    /**
     * An expectation for checking an element is visible and enabled such that
     * you can click it.
     */
    public boolean isClickableWebElement(ControlLocation controlLocation) {
        isLoadComplete();
        return context.isClickableWebElement(controlLocation);
    }
    
    /**
     * An expectation for checking that an element is either invisible or not
     * present on the DOM.
     */
    public boolean isInvisibleWebElement(ControlLocation controlLocation) {
        isLoadComplete();
        return context.isInvisibleWebElement(controlLocation);
    }

    /**
     * An expectation for checking that an element with text is either invisible
     * or not present on the DOM.
     */
    public boolean isInvisibleWebElementWithText(ControlLocation controlLocation, String text) {
        isLoadComplete();
        return context.isInvisibleWebElementWithText(controlLocation, text);
    }

    public boolean isInvisibleWebElementById(String id) {
        isLoadComplete();
        return isInvisibleWebElement(ControlLocation.getById(id));
    }

    public boolean isInvisibleWebElementByPartialLinkText(String partialLinkText) {
        isLoadComplete();
        return isInvisibleWebElement(ControlLocation.getByPartialLinkText(partialLinkText));
    }

    /**
     * Wait until an element is no longer attached to the DOM.
     * Do not mix implicit and explicit waits.
     */
    public boolean isStatelessOfWebElement(ControlWrapper controlWrapper) {
        isLoadComplete();
        return context.isStatelessOfWebElement(controlWrapper);
    }

    //TODO +++ not public
    Select getVisibleSelectWebElement(ControlLocation controlLocation) {
        return new Select(getVisibleWebElement(controlLocation));
    }

    Select getVisibleSelectWebElement(ControlWrapper controlWrapper) {
        isLoadComplete();
        return new Select(controlWrapper.getWebElement());
    }

    Select getPresentSelectWebElement(ControlLocation controlLocation) {
        return new Select(getPresentWebElement(controlLocation));
    }

    Select getPresentSelectWebElement(ControlWrapper controlWrapper) {
        isLoadComplete();
        return new Select(controlWrapper.getWebElement());
    }

    public boolean isVisibleTitle(String partialTitle) {
        isLoadComplete();
        return context.isVisibleTitle(partialTitle);
    }

}
