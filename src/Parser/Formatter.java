package Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Formatter{
	private ProgramNode programNode = null;
	private String FORMAT = "";
	private Parser parser;

	public Formatter(Scanner s, String format) {
		this.FORMAT = format;
		parser = new Parser(FORMAT);
		parseFile(s);
	}

	public Formatter(String fileName, String format) {
		this.FORMAT = format;
		parser = new Parser(FORMAT);
		Scanner scan = null;
		File file = new File(fileName);
		try {
			scan = new Scanner(file);
			parseFile(scan);
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("\nProgram ended");
		}
	}

	public String toString() {
		if(programNode!=null) {
			return programNode.toString();
		}
		return "";
	}

	public void parseFile(Scanner s) {
		programNode = new ProgramNode();
		while (s.hasNext()) {
			programNode.getStatements().add(parser.parseStatement(s));
		}
	}
}
