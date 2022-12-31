package net.lithe.log;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.logging.LogRecord;
import java.util.logging.Logger;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleLogger extends Logger {

    private String format = "";


    public SimpleLogger(String name, String format) {
        super(name, null);
        this.format = format;
    }

    @Override
    public void log(LogRecord record) {
        String level = record.getLevel().getName();

        String message = format
                .replace("{name}", getName())
                .replace("{level}", level)
                .replace("{message}", record.getMessage());

        System.out.println(message);
    }

    public void info(@NonNull String infoMessage, Object... objects) {
        if (objects != null && objects.length != 0) super.info(String.format(infoMessage, objects));
        else super.info(infoMessage);
    }

    public void warn(@NonNull String warnMessage, Object... objects) {
        if (objects != null && objects.length != 0) super.info(String.format(warnMessage, objects));
        else super.warning(warnMessage);
    }
}
