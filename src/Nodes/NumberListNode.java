package Nodes;

public class NumberListNode extends Node {
	private String list = "";
	private String format = "";

	public NumberListNode(String list, String format) {
		this.list = list;
		this.format = format;
	}

	@Override
	public String toString() {
		if (format.equals("HTML")) return "<ol>\n" + list + "\n</ol>";
		if(format.equals("Latex")) return "\\begin{enumerate}\n" + list + "\n\\end{enumerate}";
		return "";
	}
}



