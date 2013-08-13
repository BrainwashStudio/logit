package com.brainwashstudio.logit;

public class LogMessage {
    protected int mLevel = Log.Level.VERBOSE;
    protected String mTag = null;
    protected String mText = null;
    protected Throwable mThrowable = null;

    protected LogMessage() {

    }

    public int getLevel() {
        return mLevel;
    }

    public LogMessage setLevel(int level) {
        mLevel = level;
        return this;
    }

    public String getTag() {
        return mTag;
    }

    public boolean hasTag() {
        return mTag != null;
    }

    public LogMessage setTag(String tag) {
        mTag = tag;
        return this;
    }

    public String getText() {
        return mText;
    }

    public boolean hasText() {
        return mText != null;
    }

    public LogMessage setText(String text) {
        mText = text;
        return this;
    }

    public Throwable getThrowable() {
        return mThrowable;
    }

    public boolean hasThrowable() {
        return mThrowable != null;
    }

    public LogMessage setThrowable(Throwable throwable) {
        mThrowable = throwable;
        return this;
    }

    public static LogMessage create() {
        return new LogMessage();
    }
}