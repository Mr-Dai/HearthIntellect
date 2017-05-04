package com.hearthintellect.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Util class for concurrent classes. Do not instantiate this class.
 */
public class ConcurrentUtils {
    private static final Logger LOG = LoggerFactory.getLogger(ConcurrentUtils.class);

    /**
     * Shutdown the given {@code ExecutorService} and block until it is completely terminated.
     *
     * @param executor the given {@code ExecutorService} to be shut down.
     * @throws InterruptedException if the application receives an interruption when it is waiting
     *                              for the executor to shut down.
     */
    public static void shutdownAndWait(ExecutorService executor) throws InterruptedException {
        executor.submit(() -> LOG.info("Executor shutting down..."));
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS); // Wait indefinitely
        LOG.debug("The executor is terminated.");
    }
}
