package genericListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import java.util.logging.Logger;

public class RetryListener implements IRetryAnalyzer {
    private static final Logger logger = Logger.getLogger(RetryListener.class.getName());
    private int retryCount = 0;
    private static final int MAX_RETRY = 2; // Number of retry attempts

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY) {
            retryCount++;
            logger.warning("Retrying test: " + result.getMethod().getMethodName() + " | Attempt: " + retryCount);
            return true; // Retry the test
        }
        return false; // Stop retrying after MAX_RETRY attempts
    }
}

