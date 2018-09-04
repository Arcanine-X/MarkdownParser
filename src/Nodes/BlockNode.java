package Nodes;

public class BlockNode extends Node{
	private Node node;
	private String format = "";

	public BlockNode(Node node, String format) {
		this.node = node;
		this.format = format;
	}

	@Override
	public String toString() {
		if(node instanceof EmptyNode) {
			if(format.equals("HTML")) return "<blockquote>\n" + "</blockquote>";
			if(format.equals("Latex")) return "\\begin{quote}\n" + "\\end{quote}";
		}
		if(format.equals("HTML")) return "<blockquote>\n" + node.toString() + "\n</blockquote>";
		if(format.equals("Latex"))return "\\begin{quote}\n" + node.toString() + "\n\\end{quote}";
		return "";
	}
}



