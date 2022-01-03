package TestActions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ActionsLogMessage {
    private static final Logger log = LogManager.getLogger("STEP STATUS");

    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static String START_TEST = ANSI_GREEN + "START_TEST" + ANSI_RESET;
    public static String STOP_TEST = ANSI_GREEN + "STOP_TEST" + ANSI_RESET;
    public static String PASS = ANSI_WHITE + "PASS" + ANSI_RESET;
    public static String FAIL = ANSI_RED + "FAIL" + ANSI_RESET;

    public static void getLogMessage(String status, String methodName) {
        log.info(status + ": " + methodName);
    }

    public static void getLogMessage(String status, String methodName, String exceptionData) {
        log.info(status + ": " + methodName + " .Exception: " + exceptionData);
    }
}
