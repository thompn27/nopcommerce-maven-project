package commons;

import java.io.File;

public class GlobalConstants {
    private static GlobalConstants GlobalConstants;
    private GlobalConstants(){
    }
    public static GlobalConstants getGlobalConstants(){
        if (GlobalConstants == null){
            GlobalConstants = new GlobalConstants();
        }
        return GlobalConstants;
    }

    public String getUserNopComPageUrl() {
        return userNopComPageUrl;
    }

    public String getAdminNopComPageUrl() {
        return adminNopComPageUrl;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public String getOsName() {
        return osName;
    }

    public String getUploadFile() {
        return uploadFile;
    }

    public String getDownloadFile() {
        return downloadFile;
    }

    public String getBrowserLog() {
        return browserLog;
    }

    public long getShortTimeout() {
        return shortTimeout;
    }

    public long getLongTimeout() {
        return longTimeout;
    }

    public int getRetryTestFail() {
        return retryTestFail;
    }

    private final String userNopComPageUrl = "https://demo.nopcommerce.com/";
    private final String adminNopComPageUrl = "https://admin-demo.nopcommerce.com/";
    private final String projectPath = System.getProperty("user.dir");
    private final String osName = System.getProperty("os.name");
    private final String uploadFile = projectPath + File.separator + "uploadFiles" + File.separator;
    private final String downloadFile = projectPath + File.separator + "downloadFiles";
    private final String browserLog = projectPath + File.separator + "browserLogs";
    private final long shortTimeout = 5;
    private final long longTimeout = 30;
    private final int retryTestFail = 3;
}
