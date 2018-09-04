package Nodes;

public class ParagraphNode extends Node{
	private String paragraph = "";
	private String format = "";

	public ParagraphNode(String string, String format){
		this.paragraph = string;
		this.format = format;
	}

	@Override
	public String toString() {
		if(format.equals("HTML")) return "<p>" + paragraph + "</p>";
		if(format.equals("Latex")) return paragraph + " \\par";
		return "";
	}
}
