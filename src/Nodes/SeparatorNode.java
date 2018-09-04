package Nodes;

public class SeparatorNode extends Node{
	private String format = "";

	public SeparatorNode(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		if(format.equals("HTML")) return "<hr />";
		if(format.equals("Latex")) return "\\begin{center}\\rule{0.5\\linewidth}{\\linethickness}\\end{center}";
		return "";
	}
}
