package lesson9;

public class Logger {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void setLogger(LogLevel logLevel) {

        switch (logLevel) {
            case INFO:
                System.out.println(ANSI_WHITE + logLevel.getLogLevel() + ANSI_RESET);
                break;
            case DEBUG:
                System.out.println(ANSI_GREEN + logLevel.getLogLevel() + ANSI_RESET);
                break;
            case WARNING:
                System.out.println(ANSI_YELLOW + logLevel.getLogLevel() + ANSI_RESET);
                break;
            case ERROR:
                System.out.println(ANSI_RED + logLevel.getLogLevel() + ANSI_RESET);
                break;
            default:
                System.out.println("Invalid logLevel!");
                break;
        }
    }
}
