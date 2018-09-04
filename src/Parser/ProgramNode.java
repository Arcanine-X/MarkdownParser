package Parser;
import java.util.ArrayList;

import Nodes.Node;

/**
 * This class represents the whole parsed text in a List of nodes.
 * @author patelchin1
 *
 */
public class ProgramNode {
	private ArrayList<Node> statements = new ArrayList<Node>();

	@Override
	public String toString() {
		String tree = "";
		for(int stmnt = 0; stmnt < statements.size(); stmnt++) {
			tree += statements.get(stmnt).toString();
			if(stmnt + 1 < statements.size()) {
				tree += "\n";
			}
		}
		return tree;
	}

	public ArrayList<Node> getStatements() {
		return statements;
	}
}
