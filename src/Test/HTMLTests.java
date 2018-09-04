package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import Parser.Formatter;

public class HTMLTests {
	private static final String HTML = "HTML";
	private static final TestHelper HELPER = new TestHelper();

	@Test
	public void test_paragraphs_HTML() {
		String fileName = "TestFiles/Input/test_paragraph.txt";
		Formatter parser = new Formatter(fileName, HTML);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_HTML/paragraph_HTML.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_italics_HTML() {
		String fileName = "TestFiles/Input/test_italics.txt";
		Formatter parser = new Formatter(fileName, HTML);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_HTML/italics_HTML.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_bolds_HTML() {
		String fileName = "TestFiles/Input/test_bolds.txt";
		Formatter parser = new Formatter(fileName, HTML);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_HTML/bolds_HTML.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_nestedAsterix_HTML() {
		String fileName = "TestFiles/Input/test_nestedAsterix.txt";
		Formatter parser = new Formatter(fileName, HTML);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_HTML/nestedAsterix_HTML.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_headers_HTML() {
		String fileName = "TestFiles/Input/test_headers.txt";
		Formatter parser = new Formatter(fileName, HTML);
		String actual = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_HTML/headers_HTML.txt");
		assertEquals(expected, actual);
	}

	@Test
	public void testNumberedList() {
		String fileName = "TestFiles/Input/test_numberedList2.txt";
		Formatter parser = new Formatter(fileName, HTML);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_HTML/numberedList2_HTML.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_numberedList_HTML() {
		String fileName = "TestFiles/Input/test_numberedList.txt";
		Formatter parser = new Formatter(fileName, HTML);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_HTML/numberedList_HTML.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_bulletPoints() {
		String fileName = "TestFiles/Input/test_bulletPoint.txt";
		Formatter parser = new Formatter(fileName, HTML);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_HTML/bulletPoint_HTML.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_separator_HTML() {
		String fileName = "TestFiles/Input/test_separator.txt";
		Formatter parser = new Formatter(fileName, HTML);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_HTML/separator_HTML.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_blockQuote_HTML() {
		String fileName = "TestFiles/Input/test_blockQuote.txt";
		Formatter parser = new Formatter(fileName, HTML);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_HTML/blockQuote_HTML.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_inlineCode_HTML() {
		String fileName = "TestFiles/Input/test_inlineCode.txt";
		Formatter parser = new Formatter(fileName, HTML);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_HTML/inlineCode_HTML.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void test_blockCode_HTML() {
		String fileName = "TestFiles/Input/test_blockCode.txt";
		Formatter parser = new Formatter(fileName, HTML);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_HTML/blockCode_HTML.txt");
		assertEquals(expected, parsed);
	}

	@Test
	public void testBlockCode2() {
		String fileName = "TestFiles/Input/test_blockCode2.txt";
		Formatter parser = new Formatter(fileName, HTML);
		String parsed = parser.toString();
		String expected = HELPER.getExpected("TestFiles/ExpectedOutput_HTML/blockCode2_HTML.txt");
		assertEquals(expected, parsed);
	}
}



