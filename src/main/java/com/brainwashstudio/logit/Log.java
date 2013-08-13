package com.brainwashstudio.logit;

public final class Log {
    // Because if we just passed "null", we would have to put (String) before it
    private static final String NULL = null;

    private static ILogService sLogService = null;
    private static int sLoggingLevel = Level.ERROR;


    public static void setLogService(ILogService service) {
        sLogService = service;
    }
    
    public static int getLoggingLevel() {
        return sLoggingLevel;
    }

    public static void setLoggingLevel(int level) {
        sLoggingLevel = level;
    }

    public static boolean loggable(int level) {
        return sLogService != null && sLoggingLevel != Level.MUTE && sLoggingLevel <= level;
    }

    public static void v(String text) {
        v(NULL, text);
    }

    public static void v(Class tagClass, String text) {
        v(tagClass.getName(), text);
    }

    public static void v(String tag, String text) {
        log(Level.VERBOSE, tag, text);
    }

    public static void d(String text) {
        d(NULL, text);
    }

    public static void d(Class tagClass, String text) {
        d(tagClass.getName(), text);
    }

    public static void d(String tag, String text) {
        log(Level.DEBUG, tag, text);
    }

    public static void i(String text) {
        i(NULL, text);
    }

    public static void i(Class tagClass, String text) {
        i(tagClass.getName(), text);
    }

    public static void i(String tag, String text) {
        log(Level.INFO, tag, text);
    }

    public static void w(String text) {
        w(NULL, text);
    }

    public static void w(Class tagClass, String text) {
        w(tagClass.getName(), text);
    }

    public static void w(String tag, String text) {
        log(Level.WARNING, tag, text);
    }

    public static void e(String text) {
        e(text, (Throwable) null);
    }

    public static void e(String text, Throwable t) {
        e(NULL, text, t);
    }

    public static void e(Class tagClass, String text) {
        e(tagClass, text, null);
    }

    public static void e(Class tagClass, String text, Throwable t) {
        e(tagClass.getName(), text, t);
    }

    public static void e(String tag, String text) {
        e(tag, text, null);
    }

    public static void e(String tag, String text, Throwable t) {
        log(Level.ERROR, tag, text, t);
    }

    public static void log(int level, String text) {
        log(level, NULL, text);
    }

    public static void log(int level, String tag, String text) {
        log(level, tag, text, null);
    }

    public static void log(int level, Class tagClass, String text) {
        log(level, tagClass, text, null);
    }

    public static void log(int level, Class tagClass, String text, Throwable t) {
        log(level, tagClass.getName(), text, t);
    }

    public static void log(int level, String text, Throwable t) {
        log(level, NULL, text, t);
    }

    public static void log(int level, String tag, String text, Throwable t) {
        if(!loggable(level)) {
            return;
        }

        sLogService.log(LogMessage.create().setLevel(level).setTag(tag).setText(text).setThrowable(t));
    }

    public static void log(LogMessage message) {
        if(!loggable(message.getLevel())) {
            return;
        }

        sLogService.log(message);
    }

    public static void writeLine(String line) {
        if(sLogService != null) {
            sLogService.writeLine(line);
        }
    }

    public class Level {
        public static final int VERBOSE = 2;
        public static final int DEBUG = 3;
        public static final int INFO = 4;
        public static final int WARNING = 5;
        public static final int ERROR = 6;
        public static final int MUTE = Integer.MAX_VALUE;
    }

}