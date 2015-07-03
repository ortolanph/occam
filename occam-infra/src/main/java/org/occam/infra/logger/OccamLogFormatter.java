package org.occam.infra.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class OccamLogFormatter extends Formatter {
    private static final String LOG_FORMAT = "[%s][%s][%s] %s";
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss yyyy.MM.dd");

    @Override
    public String format(LogRecord record) {
        return String.format(LOG_FORMAT,
                sdf.format(new Date(record.getMillis())),
                record.getClass().getCanonicalName(),
                record.getLevel().toString(),
                record.getMessage());
    }

}
