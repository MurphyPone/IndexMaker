import java.util.ArrayList;

public class DocumentIndex extends ArrayList<IndexEntry> { //Represents the entire index for the document, list of all its index entries
	private ArrayList<IndexEntry> list;
	
	public DocumentIndex() {
		//call respective ArrayList supeR???
		list = new ArrayList<IndexEntry>();
	}
	
	public DocumentIndex(int size) {
		list = new ArrayList<IndexEntry>(size);
	}
	
	
	public void addWord(String word, int num) { 
		list.add(word.add(num));//what!
	}
	
	public void addAllWords(String str, int num) { 
		for(int i = 0; i <list.size(); i++) {
			list.get(i).getWord().addWord(str, num);
		}
		//use regular expression? adn string.split
	}
	
	
	//Not sure what this is for
	private int foundOrInster(String word) {
		return 5;
	}

}
