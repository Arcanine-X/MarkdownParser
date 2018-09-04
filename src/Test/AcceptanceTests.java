package Test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import Parser.Formatter;

public class AcceptanceTests {
	private static final String HTML = "HTML";
	private static final String LATEX = "Latex";
	private static final TestHelper HELPER = new TestHelper();

	@Test
	public void acceptanceTest_1() {
		String fileName = "TestFiles/AcceptanceTests/AcceptanceTest_1.txt";
		Formatter HTML_Parser = new Formatter(fileName, HTML);
		Formatter Latex_Parser = new Formatter(fileName, LATEX);
		String HTML_parsed = HTML_Parser.toString();
		String Latex_parsed = Latex_Parser.toString();
		String HTML_expected = HELPER.getExpected("TestFiles/AcceptanceTests/ExpectedA1_HTML.txt");
		String Latex_expected = HELPER.getExpected("TestFiles/AcceptanceTests/ExpectedA1_Latex.txt");
		writeToFile(HTML_parsed, Latex_parsed, "AcceptanceTest_1_HTML_Output.txt", "AcceptanceTest_1_Latex_Output.txt");
		assertEquals(HTML_expected, HTML_parsed);
		assertEquals(Latex_expected, Latex_parsed);
	}

	@Test
	public void acceptanceTest_2() {
		String fileName = "TestFiles/AcceptanceTests/AcceptanceTest_2.txt";
		Formatter HTML_Parser = new Formatter(fileName, HTML);
		Formatter Latex_Parser = new Formatter(fileName, LATEX);
		String HTML_parsed = HTML_Parser.toString();
		String Latex_parsed = Latex_Parser.toString();
		String HTML_expected = HELPER.getExpected("TestFiles/AcceptanceTests/ExpectedA2_HTML.txt");
		String Latex_expected = HELPER.getExpected("TestFiles/AcceptanceTests/ExpectedA2_Latex.txt");
		writeToFile(HTML_parsed, Latex_parsed, "AcceptanceTest_2_HTML_Output.txt", "AcceptanceTest_2_Latex_Output.txt");
		assertEquals(HTML_expected, HTML_parsed);
		assertEquals(Latex_expected, Latex_parsed);
	}

	@Test
	public void acceptanceTest_3() {
		String fileName = "TestFiles/AcceptanceTests/AcceptanceTest_3.txt";
		Formatter HTML_Parser = new Formatter(fileName, HTML);
		Formatter Latex_Parser = new Formatter(fileName, LATEX);
		String HTML_parsed = HTML_Parser.toString();
		String Latex_parsed = Latex_Parser.toString();
		String HTML_expected = HELPER.getExpected("TestFiles/AcceptanceTests/ExpectedA3_HTML.txt");
		String Latex_expected = HELPER.getExpected("TestFiles/AcceptanceTests/ExpectedA3_Latex.txt");
		writeToFile(HTML_parsed, Latex_parsed, "AcceptanceTest_3_HTML_Output.txt", "AcceptanceTest_3_Latex_Output.txt");
		assertEquals(HTML_expected, HTML_parsed);
		assertEquals(Latex_expected, Latex_parsed);
	}

	@Test
	public void acceptanceTest_4() {
		String fileName = "TestFiles/AcceptanceTests/AcceptanceTest_4.txt";
		Formatter HTML_Parser = new Formatter(fileName, HTML);
		Formatter Latex_Parser = new Formatter(fileName, LATEX);
		String HTML_parsed = HTML_Parser.toString();
		String Latex_parsed = Latex_Parser.toString();
		String HTML_expected = HELPER.getExpected("TestFiles/AcceptanceTests/ExpectedA4_HTML.txt");
		String Latex_expected = HELPER.getExpected("TestFiles/AcceptanceTests/ExpectedA4_Latex.txt");
		writeToFile(HTML_parsed, Latex_parsed, "AcceptanceTest_4_HTML_Output.txt", "AcceptanceTest_4_Latex_Output.txt");
		assertEquals(HTML_expected, HTML_parsed);
		assertEquals(Latex_expected, Latex_parsed);
	}

	@Test
	public void acceptanceTest_5() {
		String fileName = "TestFiles/AcceptanceTests/AcceptanceTest_5.txt";
		Formatter HTML_Parser = new Formatter(fileName, HTML);
		Formatter Latex_Parser = new Formatter(fileName, LATEX);
		String HTML_parsed = HTML_Parser.toString();
		String Latex_parsed = Latex_Parser.toString();
		String HTML_expected = HELPER.getExpected("TestFiles/AcceptanceTests/ExpectedA5_HTML.txt");
		String Latex_expected = HELPER.getExpected("TestFiles/AcceptanceTests/ExpectedA5_Latex.txt");
		writeToFile(HTML_parsed, Latex_parsed, "AcceptanceTest_5_HTML_Output.txt", "AcceptanceTest_5_Latex_Output.txt");
		assertEquals(HTML_expected, HTML_parsed);
		assertEquals(Latex_expected, Latex_parsed);
	}

	@Test
	public void acceptanceTest_6() {
		String fileName = "TestFiles/AcceptanceTests/AcceptanceTest_6.txt";
		Formatter HTML_Parser = new Formatter(fileName, HTML);
		Formatter Latex_Parser = new Formatter(fileName, LATEX);
		String HTML_parsed = HTML_Parser.toString();
		String Latex_parsed = Latex_Parser.toString();
		String HTML_expected = HELPER.getExpected("TestFiles/AcceptanceTests/ExpectedA6_HTML.txt");
		String Latex_expected = HELPER.getExpected("TestFiles/AcceptanceTests/ExpectedA6_Latex.txt");
		writeToFile(HTML_parsed, Latex_parsed, "AcceptanceTest_6_HTML_Output.txt", "AcceptanceTest_6_Latex_Output.txt");
		assertEquals(HTML_expected, HTML_parsed);
		assertEquals(Latex_expected, Latex_parsed);
	}

	private void writeToFile(String parsedHTML, String parsedLatex, String outputToHTML, String outputToLatex){
		PrintWriter writer;
		try {
			writer = new PrintWriter(outputToHTML, "UTF-8");
			writer.println(parsedHTML);
			writer.close();
			writer = new PrintWriter(outputToLatex, "UTF-8");
			writer.println(parsedLatex);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
