package com.brainwashstudio.logit;

public abstract class LogService implements ILogService {

    protected abstract void verboseLevel(LogMessage message);

    protected abstract void debugLevel(LogMessage message);

    protected abstract void infoLevel(LogMessage message);

    protected abstract void warningLevel(LogMessage message);

    protected abstract void errorLevel(LogMessage message);

    protected abstract void unknownLevel(LogMessage message);

    @Override
    public void log(LogMessage message) {
        switch(message.getLevel()) {
            case Log.Level.VERBOSE:
                verboseLevel(message);
                break;
            case Log.Level.DEBUG:
                debugLevel(message);
                break;
            case Log.Level.INFO:
                infoLevel(message);
                break;
            case Log.Level.WARNING:
                warningLevel(message);
                break;
            case Log.Level.ERROR:
                errorLevel(message);
                break;
            case Log.Level.MUTE:
                throw new IllegalStateException("LogMessage can't have level of Log.Level.MUTE (Integer.MAX_VALUE)!");
            default:
                unknownLevel(message);
                break;
        }
    }

}