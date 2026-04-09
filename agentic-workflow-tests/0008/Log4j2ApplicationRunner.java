package com.golf.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.async.AsyncLoggerConfig;
import org.apache.logging.log4j.core.async.AsyncLoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Log4j2ApplicationRunner implements ApplicationRunner {

    @Override
    public void run(org.springframework.boot.ApplicationArguments args) throws Exception {
        Class<?> loggerContextClass = LoggerContext.class;
        Object context = LogManager.getContext(false);
        if( ! loggerContextClass.isInstance(context) ) {
            log.error( "Logger context is not instance of '{}', but istanse of '{}'", loggerContextClass.getName(), context.getClass().getName() );
            return;
        }
        @SuppressWarnings("resource")
        LoggerContext loggerContext = (LoggerContext) context;

        // Check if context is async and all loggers are made asynchronous globally
        boolean isAsyncContext = loggerContext instanceof AsyncLoggerContext;
        log.info("Async Logger Context: {}", isAsyncContext);

        Configuration config = loggerContext.getConfiguration();

        // Check if loggers are individually configured as asynchronous
        config.getLoggers().forEach((name, loggerConfig) -> {
            if( name==null || name.isEmpty() ) {
                name = "ROOT";
            }
            boolean isAsync = loggerConfig instanceof AsyncLoggerConfig;
            log.info("LoggerConfig: {} is Async: {}", name, isAsync);
        });

        // List appenders
        config.getAppenders().forEach((name, appender) -> {
            log.info("Appender: {} Type: {}", name, appender.getClass().getSimpleName());
        });
    }
}
