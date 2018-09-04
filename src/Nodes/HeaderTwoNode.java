package Nodes;

public class HeaderTwoNode extends Node {
	private String line = "";
	private String format = "";

	public HeaderTwoNode(String line, String format) {
		this.line = line;
		this.format = format;
	}

	@Override
	public String toString() {
		if (format.equals("HTML")) return "<h2>" + line + "</h2>";
		if (format.equals("Latex")) return "\\subsection{" + line + "}";
		return "";
	}
}

