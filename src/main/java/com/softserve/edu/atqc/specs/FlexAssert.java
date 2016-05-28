package com.softserve.edu.atqc.specs;

import org.testng.Assert;

import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.loggers.LoggerUtils;
import com.softserve.edu.atqc.tools.CaptureScreenImage;

public class FlexAssert {
    private final String NEW_LINE = "\n";
    private final String APPEND_TEXT = "%sDescription: %s";
    private final String SCREEN_IMAGE_PATH = "Screen image is located by the next path %s";
    //
    private static volatile FlexAssert instance = null;
    // TODO Change to Multiply Threads
    private boolean summaryResult;
    private StringBuffer summaryDescription;

    private FlexAssert() {
        this.summaryResult = true;
        this.summaryDescription = new StringBuffer();
    }

    public static FlexAssert get() {
        if (instance == null) {
            synchronized (FlexAssert.class) {
                if (instance == null) {
                    instance = new FlexAssert();
                }
            }
        }
        return instance;
    }

    // getters

    public boolean getPassed() {
        return summaryResult;
    }

    public String getSummaryDescription() {
        return summaryDescription.toString();
    }

    // business

    public void verify(boolean pass, String errorText) {
        summaryResult = summaryResult && pass;
        if (!pass) {
            summaryDescription.append(String.format(APPEND_TEXT, NEW_LINE, errorText));
            LoggerUtils.get().errorLog(errorText);
            String fileNamePath = CaptureScreenImage.get().captureAndSaveScreen();
            //
            LoggerUtils.get().errorLog(String.format(SCREEN_IMAGE_PATH, fileNamePath));
            LoggerUtils.get().insertPathToScreenShot(fileNamePath);
            // TODO Get Html Code
        }
    }

    public void addWarning(String warningText) {
        summaryDescription.append(String.format(APPEND_TEXT, NEW_LINE, warningText));
    }

    public void check() {
        boolean result = getPassed();
        String description = getSummaryDescription();
        this.summaryResult = true;
        // TODO Clear StringBuffer
        this.summaryDescription = new StringBuffer();
        Assert.assertTrue(result, description);
    }

    public ITextCriteria forElement(String text) {
        return TextCriteria.get(text);
    }

    // public ComponentCriteria forElement(IComponent component) {
    // return ComponentCriteria.get(component);
    // }

    public ILabelCriteria forElement(ILabel label) {
        return LabelCriteria.get(label);
    }

    public ILinkCriteria forElement(ILink link) {
        return LinkCriteria.get(link);
    }

     public IButtonCriteria forElement(IButton button) {
     return ButtonCriteria.get(button);
     }

    public ITextFieldCriteria forElement(ITextField textField) {
        return TextFieldCriteria.get(textField);
    }

}
