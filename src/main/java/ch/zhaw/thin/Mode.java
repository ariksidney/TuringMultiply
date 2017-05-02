package ch.zhaw.thin;

import ch.qos.logback.classic.Level;

/**
 * @author Arik, Simon
 */
public class Mode {

    public static void setRunMode(boolean verbose) {
        if (verbose) {
            setMode(Level.DEBUG);
        } else {
            setMode(Level.INFO);
        }
    }

    public static void setStepMode() {
        setMode(Level.TRACE);
    }


    private static void setMode(Level level) {
        ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger)
                org.slf4j.LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
        root.setLevel(level);
    }
}
