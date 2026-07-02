package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 1: Logging Error Messages and Warning Levels
 *
 * This class demonstrates logging using SLF4J (Simple Logging Facade for Java).
 *
 * SLF4J is not a logging framework by itself — it's a "facade" or abstraction
 * that sits on top of actual logging implementations like Logback, Log4j, etc.
 * The benefit is that we write our logging code once using SLF4J, and we can
 * swap the underlying implementation without changing any code.
 *
 * Log Levels (from most severe to least):
 *   ERROR - Something went seriously wrong, needs immediate attention
 *   WARN  - Something unexpected happened, but the app can still continue
 *   INFO  - General information about what the application is doing
 *   DEBUG - Detailed info useful during development and debugging
 *   TRACE - Very fine-grained, usually only enabled when hunting down a tough bug
 *
 * In production, you'd typically set the level to WARN or ERROR so you don't
 * flood your logs. During development, DEBUG or TRACE can be really helpful.
 */
public class LoggingExample {

    // Create a logger for this class — each class gets its own logger
    // so we can easily tell where each log message came from
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        System.out.println("=== SLF4J Logging Demo ===\n");

        // ERROR level — for serious problems
        // Use this when something fails and needs attention right away
        logger.error("This is an error message");
        logger.error("Database connection failed — retrying in 5 seconds");

        // WARN level — for things that aren't critical but shouldn't be ignored
        // Like a deprecated API being used, or a retry happening
        logger.warn("This is a warning message");
        logger.warn("Disk usage is above 85% — consider cleanup");

        // INFO level — general application flow information
        // Useful for tracking what the app is doing at a high level
        logger.info("Application started successfully");
        logger.info("Processing 150 records from input file");

        // DEBUG level — detailed info for developers
        // Normally turned off in production
        logger.debug("User object created: id=42, name=Yash");
        logger.debug("Cache hit ratio: 0.87");

        // TRACE level — very detailed, step-by-step execution
        // Only enable when you really need to dig into something
        logger.trace("Entering method calculateTotal() with args: [100, 200, 300]");

        // SLF4J also supports parameterized messages — this is better than
        // string concatenation because the string isn't built if the log
        // level is disabled (saves performance)
        String username = "Yash";
        int itemCount = 5;
        logger.info("User {} added {} items to cart", username, itemCount);

        // Logging exceptions — you can pass an exception as the last argument
        // and SLF4J will print the full stack trace
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Failed to perform calculation", e);
        }

        System.out.println("\n=== Check the console output above for log messages ===");
        System.out.println("Notice how each log line shows the level, timestamp, and class name.");
    }
}
