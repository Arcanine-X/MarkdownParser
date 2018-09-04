package Parser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Helper {

	/**
	 * Joins a list of strings together by appending spaces after each item.
	 * @param list
	 * @param separator
	 * @return
	 */
	public String joiner(List<String> list, String separator){
	    StringBuilder result = new StringBuilder();
	    //remove empty lines
	    if(!list.isEmpty() && list.get(0).trim().length() == 0) {
		    list.remove(0);
	    }
	    for(String term : list) {
	    	if(term.equals("\n")) {
	    		//remove space at end of sentence
	    		result.deleteCharAt(result.length()-1);
	    		result.append(term);
	    		continue;
	    	}
	    	if(term.equals("<li>")) {
	    		result.append(term);
	    		continue;
	    	}
	    	result.append(term + separator);
	    }
	    if(result.length()>1)
	    result.deleteCharAt(result.length()-1);
	    return result.toString();
	}

	/**
	 * Adds the given line to the given list after its been tokenized.
	 * @param tokenized
	 * @param line
	 * @return
	 */
	public List<String> listCombiner(List<String>tokenized, String line){
		List<String> tempList = new ArrayList<>(Arrays.asList(line.split(" ")));
		List<String> returnList = new ArrayList<>();
		returnList.addAll(tokenized);
		if(tokenized.size() != 0){
			returnList.add("\n");
		}
		returnList.addAll(tempList);
		return returnList;
	}

	public boolean checkStartsWith(String tag, String token) {
		if(tag.equals("*")) return (token.startsWith("*") && token.length()>1 && !token.substring(1).startsWith("*"));
		if(tag.equals("**")) return (token.startsWith("**") && token.length()>2 && !token.substring(2).startsWith("*"));
		if(tag.equals("`")) return (token.startsWith("`") && token.length()>1 && !token.substring(1).startsWith("`"));
		return false;
	}

	public boolean checkEndsWith(String tag, String token) {
		if(tag.equals("*")) return (token.endsWith("*") && token.length() > 1 && !token.substring(0, token.length()-1).endsWith("*"));
		if(tag.equals("**")) return (token.endsWith("**") && token.length() > 2 && !token.substring(0, token.length()-2).endsWith("*"));
		if(tag.equals("`")) return (token.endsWith("`") && token.length() > 1 && !token.substring(0, token.length()-1).endsWith("`"));
		return false;
	}

	public String consume(String p, Scanner s) {
		if (s.hasNext(p)) return s.next();
		return null;
	}
}
