package Test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ HTMLTests.class, LatexTests.class, AcceptanceTests.class})

public class TestSuite {
	public void run() {
		System.out.println("\n\nNormal unit tests were executed");
		Result result_unitTests = JUnitCore.runClasses(HTMLTests.class, LatexTests.class);
		if (result_unitTests.wasSuccessful()) {
			System.out.println("Output: Tests successful were " + result_unitTests.getRunCount() + "/" + result_unitTests.getRunCount());
		} else {
			System.out.println("Tests successful were " + (result_unitTests.getRunCount() - result_unitTests.getFailureCount()) + "/" + result_unitTests.getRunCount());
			System.out.println("\n Failures were:");
			for (Failure failure : result_unitTests.getFailures()) {
				System.out.println("Test failed :");
				System.out.println(failure.toString() + "\n");
			}
		}

		System.out.println("\n\nAcceptances tests were executed:");
		Result result_AcceptanceTests = JUnitCore.runClasses(AcceptanceTests.class);
		if (result_AcceptanceTests.wasSuccessful()) {
			System.out.println("Output: Acceptance Tests successful were " + result_AcceptanceTests.getRunCount() + "/" + result_AcceptanceTests.getRunCount());
			System.out.println("\nFiles outputted should have been:");
			System.out.println("   AcceptanceTest_1_HTML_Output.txt");
			System.out.println("   AcceptanceTest_1_Latex_Output.txt");
			System.out.println("   AcceptanceTest_2_HTML_Output.txt");
			System.out.println("   AcceptanceTest_2_Latex_Output.txt");
			System.out.println("   AcceptanceTest_3_HTML_Output.txt");
			System.out.println("   AcceptanceTest_3_Latex_Output.txt");
			System.out.println("   AcceptanceTest_4_HTML_Output.txt");
			System.out.println("   AcceptanceTest_4_Latex_Output.txt");
			System.out.println("   AcceptanceTest_5_HTML_Output.txt");
			System.out.println("   AcceptanceTest_5_Latex_Output.txt");
			System.out.println("   AcceptanceTest_6_HTML_Output.txt");
			System.out.println("   AcceptanceTest_6_Latex_Output.txt");
		}
	}
}
