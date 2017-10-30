import java.util.ArrayList;

public class IndexEntry {
	private String word;
	private ArrayList<Integer> numsList; //Contains line numbers where <word> occurs 
	
	public IndexEntry(String a) {
		word = a.toUpperCase();
		numsList = new ArrayList<Integer>();
	}
	
	public void add(int num) {	//Appends num to numslist if it is not already in the list
		if(!numsList.contains(num)) {	//numsList does not already have that num 
			numsList.add(num);
		}
	}
	
	//Helper for addWords...
	public ArrayList<Integer> getNumsList() {
		return numsList;
	}
	
	public String getWord() {
		return word;
	}
	
	public String toString() {	//Verify format
		String result = word + "\t\t";	//.toLowerCase() here 
		
		result += numsList.get(0);	//First entry doesn't have a leading comma
		for(int i = 1; i < numsList.size(); i ++) {
			result += ", " + numsList.get(i); //Adds the line where the number appears "foo	4, 5"
		}
		return result;
	}
}
