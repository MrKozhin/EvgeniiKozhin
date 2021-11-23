package com.epam.tc.hw4.listener;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import java.io.InputStream;

public class Listener {

    public void attachScreenshotFromInputStream(final String nameOfAttachment, InputStream screenshotIS) {
        Allure.addAttachment(nameOfAttachment, screenshotIS);
    }

    @Attachment
    public String attachReport(String report) {
        return report;
    }
}
