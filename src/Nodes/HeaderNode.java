package Nodes;

public class HeaderNode extends Node{
	private String line = "";
	private String format = "";

	public HeaderNode(String line, String format) {
		this.line = line;
		this.format = format;
	}

	@Override
	public String toString() {
		if(format.equals("HTML")) return "<h1>" + line + "</h1>";
		if(format.equals("Latex")) return "\\section{" + line + "}";
		return "";
	}
}

