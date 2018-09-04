package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestHelper {

	public String getExpected(String filePath){
		try {
			return  readFile(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	//https://stackoverflow.com/questions/326390/how-do-i-create-a-java-string-from-the-contents-of-a-file?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
	public String readFile(String file) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = "\n";
	    try {
	        while((line = reader.readLine()) != null) {
	            stringBuilder.append(line);
	            stringBuilder.append(ls);
	        }
	        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
	      } finally {
	        reader.close();
	    }
	}
}
