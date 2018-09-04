package Parser;

/**
 * This class is used to store the index of a word so that
 * italics, bolds, and back ticks can be kept track of.
 * @author patelchin1
 *
 */
public class WordIndex {
	private String word = "";
	private int index = -1;

	public WordIndex(String word, int index) {
		this.word = word;
		this.index = index;
	}

	public String getWord() {
		return word;
	}

	public int getIndex() {
		return index;
	}
}
