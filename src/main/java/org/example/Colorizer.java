package org.example;

public class Colorizer {
    private static final boolean SUPPORTS_COLOR = checkColorSupport();

    private static boolean checkColorSupport() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("windows")) {
                return supportsWindowsANSI();
            } else {
                return supportsUnixANSI();
            }
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean supportsWindowsANSI() {
        String windowsVersion = System.getProperty("os.version");
        if (windowsVersion == null) {
            return false;
        }
        return isWindows10OrNewer(windowsVersion);
    }

    private static boolean isWindows10OrNewer(String version) {
        try {
            String[] versions = version.split("\\.");
            if (versions.length >= 2) {
                int major = Integer.parseInt(versions[0]);
                return major >= 10; // Windows 10+ supports ANSI
            }
        } catch (NumberFormatException e) {
            // If version parsing fails, assume no support
        }
        return false;
    }

    private static boolean supportsUnixANSI() {
        String term = System.getenv("TERM");
        return term != null && !term.equals("dumb") && System.console() != null;
    }

    public static String colorize(String text, String ansiColor) {
        return SUPPORTS_COLOR ? (ansiColor + text + "\u001B[0m") : text;
    }

    public static String red(String text) {
        return colorize(text, "\u001B[31m");
    }

    public static String green(String text) {
        return colorize(text, "\u001B[32m");
    }

    public static String yellow(String text) {
        return colorize(text, "\u001B[33m");
    }

    public static String blue(String text) {
        return colorize(text, "\u001B[34m");
    }

    public static String purple(String text) {
        return colorize(text, "\u001B[35m");
    }

    public static String cyan(String text) {
        return colorize(text, "\u001B[36m");
    }
}
