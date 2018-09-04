import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Parser.Formatter;
import Test.TestSuite;

/**
 * @author Chintan Patel
 */
public class Main {
	public static void main(String[] args) {
		List<String> commands = Arrays.asList(args);
		if(commands.isEmpty()) {
			System.out.println("No file name was provided");
			return;
		}
		if(commands.contains("runTests")) {
			TestSuite tests = new TestSuite();
			tests.run();
			return;
		}
		Formatter formatHTML, formatLatex;
		PrintWriter HTML_Writer, Latex_Writer;
		Scanner scanHTML = null, scanLatex = null;
		File file = new File(args[0]);
		try {
			scanHTML     = new Scanner(file);
			scanLatex    = new Scanner(file);
			formatHTML   = new Formatter(scanHTML, "HTML");
			formatLatex  = new Formatter(scanLatex, "Latex");
			HTML_Writer  = new PrintWriter("output_HTML.txt", "UTF-8");
			Latex_Writer = new PrintWriter("output_Latex.txt", "UTF-8");
			System.out.println("\nProgram Started");
			HTML_Writer.println(formatHTML.toString());
			Latex_Writer.println(formatLatex.toString());
			System.out.println("The file " + args[0] + " was converted to HTML and Latex");
			System.out.println("The files were outputted to output_HTML.txt and output_Latex.txt");
			HTML_Writer.close();
			Latex_Writer.close();
			scanHTML.close();
			scanLatex.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("\nPlease ensure the file you are trying to convert is in the top level directory eg as the sample.txt");
		}finally {
			System.out.println("Program ended");
		}
	}
}
