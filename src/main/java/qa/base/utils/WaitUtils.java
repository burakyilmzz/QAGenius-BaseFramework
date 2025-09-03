package qa.base.utils;

import org.awaitility.Awaitility;
import java.time.Duration;
import java.util.concurrent.Callable;

public class WaitUtils {

    public static void waitUntil(Callable<Boolean> condition) {
        waitUntil(condition, Duration.ofSeconds(10));
    }

    public static void waitUntil(Callable<Boolean> condition, Duration timeout) {
        Awaitility.await()
                .atMost(timeout)
                .pollInterval(Duration.ofMillis(500))
                .until(condition);
    }

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}