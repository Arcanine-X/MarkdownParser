package Test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Parser.Formatter;

public class LatexTests {
	private static final String LATEX = "Latex";
	private static final TestHelper HELPER = new TestHelper();

	@Test
	public void test_paragraph_latex() {
		String fileName = "TestFiles/Input/test_paragraph.txt";
		Formatter parser = new Formatter(fileName, LATEX);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_Latex/paragraph_Latex.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_italics_latex() {
		String fileName = "TestFiles/Input/test_italics.txt";
		Formatter parser = new Formatter(fileName, LATEX);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_Latex/italic_Latex.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_bolds_latex() {
		String fileName = "TestFiles/Input/test_bolds.txt";
		Formatter parser = new Formatter(fileName, LATEX);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_Latex/bold_Latex.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_nestedAsterix_latex() {
		String fileName = "TestFiles/Input/test_nestedAsterix.txt";
		Formatter parser = new Formatter(fileName, LATEX);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_Latex/nestedAsterix_Latex.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_headers_latex() {
		String fileName = "TestFiles/Input/test_headers.txt";
		Formatter parser = new Formatter(fileName, LATEX);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_Latex/headers_Latex.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_numberedList_latex() {
		String fileName = "TestFiles/Input/test_numberedList.txt";
		Formatter parser = new Formatter(fileName, LATEX);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_Latex/numberedList_Latex.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_numberedList2_latex() {
		String fileName = "TestFiles/Input/test_numberedList2.txt";
		Formatter parser = new Formatter(fileName, LATEX);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_Latex/numberedList2_Latex.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_bulletPoints_latex() {
		String fileName = "TestFiles/Input/test_bulletPoint.txt";
		Formatter parser = new Formatter(fileName, LATEX);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_Latex/bulletPoint_Latex.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_separator_latex() {
		String fileName = "TestFiles/Input/test_separator.txt";
		Formatter parser = new Formatter(fileName, LATEX);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_Latex/separator_Latex.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_blockQuote_latex() {
		String fileName = "TestFiles/Input/test_blockQuote.txt";
		Formatter parser = new Formatter(fileName, LATEX);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_Latex/blockQuote_Latex.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_inlineCode_latex() {
		String fileName = "TestFiles/Input/test_inlineCode.txt";
		Formatter parser = new Formatter(fileName, LATEX);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_Latex/inlineCode_Latex.txt");
		assertEquals(expected, parsed);
	}


	@Test
	public void test_blockCode_latex() {
		String fileName = "TestFiles/Input/test_blockCode.txt";
		Formatter parser = new Formatter(fileName, LATEX);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_Latex/blockCode_Latex.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void testBlockCode2_latex() {
		String fileName = "TestFiles/Input/test_blockCode2.txt";
		Formatter parser = new Formatter(fileName, LATEX);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_Latex/blockCode2_Latex.txt");
		assertEquals(expected, parsed);
	}
}



