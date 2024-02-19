package commons;

import java.io.File;

public class GlobalConstants {
    public static final String USER_NOPCOM_PAGE_URL = "https://demo.nopcommerce.com/";
    public static final String ADMIN_NOPCOM_PAGE_URL = "https://admin-demo.nopcommerce.com/";
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
    public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    public static final int RETRY_TEST_FAIL = 3;
}
