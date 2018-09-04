package Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

import Nodes.BlockCodeNode;
import Nodes.BlockNode;
import Nodes.BulletPointNode;
import Nodes.EmptyNode;
import Nodes.HeaderNode;
import Nodes.HeaderTwoNode;
import Nodes.Node;
import Nodes.NumberListNode;
import Nodes.ParagraphNode;
import Nodes.SeparatorNode;


/**
 * This class represents a parser that is responsible for converting to both
 * HTML and Latex.
 * @author patelchin1
 *
 */
public class Parser {
	private static final Helper HELPER = new Helper();
	private static final String EMPTY = "";
	private static final String BLOCK_CODE = "```";
	private static final String NUMBER = "number";
	private static final String BULLET_POINT = "bullet";
	private static final String HTML = "HTML";
	private static final String LATEX = "Latex";
	private static final Pattern SEPARATOR = Pattern.compile("\\-{3,}\\B");
	private static final Pattern NUMBER_LIST = Pattern.compile("\\b[0-9\\.]+\\B");
	private static final Pattern EXCLUDE_NL = Pattern.compile("#|##|>|\\-{3,}\\B|\\*|```"); //exclude numberedLists
	private static final Pattern EXCLUDE_BP = Pattern.compile("#|##|>|\\-{3,}\\B|\\b[0-9\\.]+\\B|```"); //exclude bullet points
	private static final Pattern KEYWORD = Pattern.compile("#|##|>|\\-{3,}\\B|\\```|\\*|\\b[0-9\\.]+\\B");

	private String format = "";

	public Parser(String format) {
		this.format = format;
	}

	public Node parseStatement(Scanner s) {
		if(s.hasNext("#")) return parseHeader(s, "#");
		if(s.hasNext("##")) return parseHeader(s, "##");
		if(s.hasNext(SEPARATOR)) return parseSeparator(s, EMPTY);
		if(s.hasNext(">")) return parseBlockquote(s);
		if(s.hasNext(NUMBER_LIST)) return parseLists(s, NUMBER);
		if(s.hasNext("\\*")) return parseLists(s, BULLET_POINT);
		if(s.hasNext("```")) return parseBlockCode(s, EMPTY);
		if(s.hasNext()) return parseParagraph(s, EMPTY);
		return new EmptyNode();
	}

	public Node parseHeader(Scanner s, String tag) {
		HELPER.consume(tag, s);
		List<String> tokenized = setTokenized(s);
		String joinList = convert(tokenized);
		if (tag.equals("#")) return new HeaderNode(joinList, format);
		if (tag.equals("##")) return new HeaderTwoNode(joinList, format);
		return new EmptyNode();
	}


	public Node parseBlockquote(Scanner s) {
		HELPER.consume(">", s);
		if(!s.hasNextLine()) return new BlockNode(new EmptyNode(), format);
		Node node = parseStatement(s);
		return new BlockNode(node, format);
	}

	public Node parseSeparator(Scanner s, String unintendedLine) {
		String line = s.nextLine();
		List<String> tokenized = new ArrayList<>(Arrays.asList(line.split(" ")));
		if(tokenized.get(0).matches("\\-{3,}\\B")) return new SeparatorNode(format);
		if(tokenized.get(0).isEmpty()) return parseStatement(s);
		return parseParagraph(s, line);
	}

	public Node parseParagraph(Scanner s, String unintendedLine) {
		List<String> tokenized = unintendedLine.isEmpty() ? tokenized = new ArrayList<String>() : new ArrayList<>(Arrays.asList(unintendedLine.split(" ")));
		while (s.hasNext()) {
			if (s.hasNext(KEYWORD)) break; // not part of the paragraph anymore
			String line = s.nextLine();
			if (line.trim().isEmpty()) {
				String joined = HELPER.joiner(tokenized, " ");
				if (!joined.isEmpty()) return new ParagraphNode(convert(tokenized), format);
			} else {
				tokenized = HELPER.listCombiner(tokenized, line);
			}
		}
		return new ParagraphNode(convert(tokenized), format);
	}

	public Node parseBlockCode(Scanner s, String unintendedLine) {
		s.nextLine(); // consume the ````
		String toAdd = unintendedLine.isEmpty() && s.hasNext() ? s.nextLine() : unintendedLine;
		List<String> tokenized = new ArrayList<>(Arrays.asList(toAdd.split(" ")));
		while (s.hasNext()) {
			String line = s.nextLine();
			if (line.trim().equals(BLOCK_CODE)) break;
			tokenized = HELPER.listCombiner(tokenized, line);
		}
		if (tokenized.get(0).equals(BLOCK_CODE)) tokenized.remove(0);
		String joinList = HELPER.joiner(tokenized, " ");
		return new BlockCodeNode(joinList, format);
	}

	public Node parseLists(Scanner s, String listType) {
		List<String> tokenized;
		String scannedLine = s.nextLine();
		tokenized = scannedLine.isEmpty() ? new ArrayList<>() : new ArrayList<>(Arrays.asList(scannedLine.split(" ")));
		while(s.hasNext()){
			//if it has a keyword next, then break because its not part of the list anymore
			if(listType.equals(NUMBER) && s.hasNext(EXCLUDE_NL)) break;
			if(listType.equals(BULLET_POINT) && s.hasNext(EXCLUDE_BP)) break;
			String line = s.nextLine();
			if(line.trim().isEmpty()) break;
			tokenized = HELPER.listCombiner(tokenized, line);
		}

		List<String> convertItalics = converter(new ArrayList<String>(tokenized), "*");
		List<String> convertBolds = converter(new ArrayList<String>(convertItalics), "**");
		List<String> convertInlineCode = converter(new ArrayList<String>(convertBolds), "`");
		tokenized = convertInlineCode;

		if(format.equals(HTML)) convertListTagsHTML(tokenized, listType);
		if(format.equals(LATEX)) convertListTagsLatex(tokenized, listType);

		String joined = HELPER.joiner(tokenized, " ");

		if(listType.equals(NUMBER)) return new NumberListNode(joined, format);
		if(listType.equals(BULLET_POINT)) return new BulletPointNode(joined, format);
		return new EmptyNode();
	}

	public List<String> converter(List<String> line, String tag) {
		Stack<WordIndex> startTags = new Stack<>();
		List<String> convertedParagraph = new ArrayList<>(line);
		String replacementTag = getNewTag(tag);
		String startTag = getStartTag(replacementTag);
		String endTag = getEndTag(replacementTag);
		int offset = getOffset(tag);

		for (int i = 0; i < line.size(); i++) {
			String token = line.get(i);
			if (HELPER.checkStartsWith(tag, token)) {
				startTags.push(new WordIndex(token, i));
			}

			if(!(HELPER.checkEndsWith(tag, token) && !startTags.isEmpty())) continue; // no matches keep adding to list
			//found a match so pop from stack and replace asterisks
			WordIndex wordIndex = startTags.pop();
			if (wordIndex.getWord().equals(token)) {
				String trimmedWord = token.substring(offset, token.length() - offset);
				String convertedWord = startTag + trimmedWord + endTag;
				convertedParagraph.set(i, convertedWord);
			} else {
				String trimmedWord = startTag + wordIndex.getWord().substring(offset);
				convertedParagraph.set(wordIndex.getIndex(), trimmedWord);
				String convertedWord = token.substring(0, token.length() - offset);
				convertedParagraph.set(i, convertedWord + endTag);
			}
		}
		return convertedParagraph;
	}

	public String convert(List<String> tokenized) {
		List<String> convertItalics = converter(new ArrayList<String>(tokenized), "*");
		List<String> convertBolds = converter(new ArrayList<String>(convertItalics), "**");
		List<String> convertInlineCode = converter(new ArrayList<String>(convertBolds), "`");
		String joined = HELPER.joiner(convertInlineCode, " ");
		return joined;
	}

	private String getNewTag(String tag){
		if (format.equals("HTML")) {
			if (tag.equals("*")) return "em";
			if (tag.equals("**")) return "strong";
			if (tag.equals("`")) return "code";
		}
		if (format.equals("Latex")) {
			if (tag.equals("*")) return "\\textit{";
			if (tag.equals("**")) return "\\textbf{";
			if (tag.equals("`")) return "\\lstinline{";
		}
		return "";
	}

	private void convertListTagsHTML(List<String> tokenized, String listType){
		for(int i = 0; i < tokenized.size(); i++){
			String word = tokenized.get(i);
			if(!word.equals("\n")) continue;
			if(tokenized.get(i + 1).matches("\\b[0-9\\.]+\\B|\\*")){
				tokenized.set(i -1 , tokenized.get(i - 1) + "</li>");
				tokenized.set(i + 1, "<li>");
			}
		}
		tokenized.set(0, "<li>");
		tokenized.set(tokenized.size()-1, tokenized.get(tokenized.size()-1) + "</li>");
	}

	private void convertListTagsLatex(List<String> tokenized, String listType){
		for(int i = 0; i < tokenized.size(); i++){
			String word = tokenized.get(i);
			if(!word.equals("\n")) continue;
			if(tokenized.get(i + 1).matches("\\b[0-9\\.]+\\B|\\*")) tokenized.set(i + 1, "\\item");
		}
		tokenized.set(0, "\\item");

	}

	private List<String> setTokenized(Scanner s) {
		if(s.hasNext()) {
			String line = s.nextLine();
			return new ArrayList<>(Arrays.asList(line.split(" ")));
		}
		return new ArrayList<>();
	}

	private int getOffset(String tag){
		return tag.length();
	}

	private String getStartTag(String replacementTag){
		return format.equals("HTML") ? "<" + replacementTag + ">" : replacementTag;
	}

	private String getEndTag(String replacementTag){
		return format.equals("HTML") ? "</" + replacementTag + ">" : "}";
	}
}


