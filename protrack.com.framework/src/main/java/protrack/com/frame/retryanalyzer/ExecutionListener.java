package protrack.com.frame.retryanalyzer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import java.util.Set;

public class ExecutionListener implements ITestListener {
	public synchronized void onTestStart(ITestResult iTestResult) {

	}

	public synchronized void onTestSuccess(ITestResult iTestResult) {

	//	this.sendTestStatusForCount(iTestResult, "PASS");
	}

	public synchronized void onTestFailure(ITestResult iTestResult) {

	//	this.sendTestStatusForCount(iTestResult, "FAIL");
	}

	public synchronized void onTestSkipped(ITestResult iTestResult) {

	//	this.sendTestStatusForCount(iTestResult, "SKIPPED");
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	public synchronized void onStart(ITestContext iTestContext) {

	}

	public synchronized void onFinish(ITestContext iTestContext) {
		Set<ITestResult> failedTests = iTestContext.getSkippedTests().getAllResults();
		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (iTestContext.getFailedTests().getResults(method).size() > 1) {
				failedTests.remove(temp);
			} else if (iTestContext.getPassedTests().getResults(method).size() > 0) {
				failedTests.remove(temp);
			} else if (iTestContext.getSkippedTests().getResults(method).size() > 0) {
				failedTests.remove(temp);
			}
		}
		for (int i = 0; i < iTestContext.getAllTestMethods().length; i++) {
			if (iTestContext.getAllTestMethods()[i].getCurrentInvocationCount() == 4) {
				if (iTestContext.getFailedTests().getResults(iTestContext.getAllTestMethods()[i]).size() == 4
						|| iTestContext.getPassedTests().getResults(iTestContext.getAllTestMethods()[i]).size() == 1) {

					iTestContext.getFailedTests().removeResult(iTestContext.getAllTestMethods()[i]);

				}
			}
		}
	}


}

