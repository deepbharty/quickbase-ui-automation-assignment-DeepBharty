package utilities;

/**
 * FrameworkConstants stores all fixed values used across the framework.
 * These values do NOT change per environment and should remain constant.
 */
public final class FrameworkConstants {

    // Prevent object creation
    private FrameworkConstants() {}

    // Path to config.properties file
    public static final String CONFIG_PATH =
            System.getProperty("user.dir") + "/src/test/resources/configurations/config.properties";

    // Keeping system on wait for specific time for manually entering the OTP

    public static final long OTP_TIMEOUT = 180;
    // Default Explicit Wait (used in WaitUtils)
    public static final int EXPLICIT_WAIT = 10;

    // Default Implicit Wait (optional)
    public static final int IMPLICIT_WAIT = 10;

    // Page Load Timeout (used in BaseTest or WaitUtils optionally)
    public static final int PAGE_LOAD_TIMEOUT = 20;

    // Screenshot folder path (future use for reports)
    public static final String SCREENSHOT_PATH =
            System.getProperty("user.dir") + "/screenshots/";

    // Reports folder path (future use)
    public static final String REPORT_PATH =
            System.getProperty("user.dir") + "/reports/";
}
