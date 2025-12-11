package com.hei.school.model;



import java.io.IOException;

public class TerminalUtil {
    private static boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
    private static String[] originalSettings = null;


    public static void enableRawMode() {
        try {
            if (isWindows) {

            } else {

                originalSettings = getTerminalSettings();
                Runtime.getRuntime().exec(new String[]{
                        "/bin/sh", "-c", "stty raw -echo < /dev/tty"
                }).waitFor();
            }
        } catch (Exception _) {

        }
    }


    public static void disableRawMode() {
        try {
            if (!isWindows && originalSettings != null) {
                Runtime.getRuntime().exec(new String[]{
                        "/bin/sh", "-c", "stty sane < /dev/tty"
                }).waitFor();
            }
        } catch (Exception _) {

        }
    }

    private static String[] getTerminalSettings() {
        try {
            Process process = Runtime.getRuntime().exec(new String[]{
                    "/bin/sh", "-c", "stty -g < /dev/tty"
            });
            process.waitFor();
            return new String[0];
        } catch (Exception e) {
            return null;
        }
    }


    public static boolean isKeyPressed() {
        try {
            return System.in.available() > 0;
        } catch (IOException e) {
            return false;
        }
    }
}