package Nodes;

public class BlockCodeNode extends Node{
	private String blockCode = "";
	private String format = "";

	public BlockCodeNode(String blockCode, String format) {
		this.blockCode = blockCode;
		this.format = format;
	}

	@Override
	public String toString() {
		if(blockCode.isEmpty()) {
			if(format.equals("HTML")) return "<pre><code></code></pre>";
			if(format.equals("Latex")) return "\\begin{lstlisting}\\end{lstlisting}";
		}
		if(format.equals("HTML")) return "<pre><code>" + blockCode + "\n</code></pre>";
		if(format.equals("Latex"))return "\\begin{lstlisting}\n" + blockCode + "\n\\end{lstlisting}";
		return "";
	}
}


