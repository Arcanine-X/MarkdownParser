package Nodes;

public class BulletPointNode extends Node{
	private String list = "";
	private String format = "";

	public BulletPointNode(String list, String format) {
		this.list = list;
		this.format = format;
	}

	@Override
	public String toString() {
		if(format.equals("HTML"))return "<ul>\n" + list + "\n</ul>";
		if(format.equals("Latex"))return "\\begin{itemize}\n" + list + "\n\\end{itemize}";
		return "";
	}
}



