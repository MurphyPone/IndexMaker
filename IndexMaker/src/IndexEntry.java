import java.util.ArrayList;

public class IndexEntry {
	private String word;
	private ArrayList<Integer> numsList; //Contains line numbers where <word> occurs 
	
	public IndexEntry(String a) {
		word = a.toUpperCase();
		numsList = new ArrayList<Integer>();
	}
	
	public void add(int num) {	//Appends num to numslist if it is not already in the list
		numsList.add(num);
	}
	
	public String getWord() {
		return word;
	}
	
	public String toString() {	//Verify format
		String result = word + "\t";	//.toLowerCase() here 
		for(int i = 0; i < numsList.size(); i ++) {
			result += numsList.get(i) ;	//Adds the line where the number appears "foo	4, 5"
		}
		return result;
	}
}
