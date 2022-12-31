package net.lithe;

import net.lithe.log.SimpleLogger;
import net.lithe.reader.TerminalReader;
import lombok.NonNull;
import java.util.HashMap;
import java.util.Map;

public class LitheTerminal {

    private static TerminalReader reader;
    private static Map<String, SimpleLogger> loggerMap = new HashMap<>();

    static {
        loggerMap.put("default", new SimpleLogger("APP", "[{name}][{level}]: {message}"));
    }

    public static long getExecutionMills(@NonNull Runnable runnable) {
        log(LitheTerminal.class).info("Executing runnable..");
        long startMills = System.currentTimeMillis();
        runnable.run();
        long workTime = System.currentTimeMillis() - startMills;
        log(LitheTerminal.class).info("Successfully executed in %sms", workTime);
        return workTime;
    }

    public static void startReader(@NonNull TerminalReader terminalReader) {
        if (reader != null) return;
        reader = terminalReader;
        terminalReader.start();
    }

    public static void setDefaultLog(@NonNull SimpleLogger log) {
        loggerMap.put("default", log);
    }

    public static void setDefaultLogName(@NonNull String logName) {
        loggerMap.put("default", new SimpleLogger(logName, "[{name}][{level}]: {message}"));
    }

    public static SimpleLogger log(@NonNull String name) {
        if (!loggerMap.containsKey(name)) {
            loggerMap.put(name, new SimpleLogger(name, "[{name}][{level}]: {message}"));
        }
        return loggerMap.getOrDefault(name, loggerMap.get("default"));
    }

    public static SimpleLogger log() {
        return loggerMap.get("default");
    }

    public static SimpleLogger log(Class<?> o) {
        if (!loggerMap.containsKey(o.getName())) {
            loggerMap.put(o.getName(), new SimpleLogger(o.getName(), "[{name}][{level}]: {message}"));
        }
        return loggerMap.getOrDefault(o.getName(), loggerMap.get("default"));
    }
}
