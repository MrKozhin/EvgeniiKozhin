package com.epam.tc.hw4.listener;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import java.io.InputStream;

public final class AttachmentUtility {

    private AttachmentUtility() {
        throw new java.lang.UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }



    public static void attachScreenshotFromInputStream(final String nameOfAttachment, InputStream screenshotIS) {
        Allure.addAttachment(nameOfAttachment, screenshotIS);
    }

    @Attachment
    public static String attachReport(String report) {
        return report;
    }

    @Attachment(type = "image/png")
    public static byte[] makeSreenshotAttachment(final String name, final byte[] source) {
        return source;
    }
}
