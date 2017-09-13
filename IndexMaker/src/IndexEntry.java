import java.util.ArrayList;

public class IndexEntry {
	private String word;
	private ArrayList<Integer> numsList;
	
	public IndexEntry(String a) {
		word = a.toUpperCase();
		numsList = new ArrayList<Integer>();
	}
	
	public void add(int num) {
		numsList.add(num);
	}
	
	public String getWord() {
		return word;
	}
	
	public String toString() {
		String temp = "";
		for(int i = 0; i < numsList.size(); i ++) {
			temp = temp + "\n" + numsList.get(i);
		}
		return temp;
	}
}
