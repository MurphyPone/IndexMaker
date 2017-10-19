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
		if(word != "") {		//Is a valid string
			for(int i = 0; i < list.size(); i++) {
				IndexEntry entry = list.get(i);	//Temp var for the given entry[i]
				
				if(entry.getWord().equals(word)) {	//An entry exists for the given word
					entry.add(num);	//Adds num to that entry
				} else {	 //Entry does not already exist
					for(int j = 0; i < list.size(); i++) {	//Unnecessary loop?
						if(word.toLowerCase().compareTo(entry.getWord().toLowerCase()) < 0) {	//word precedes entry alphabetically
							list.add(i, new IndexEntry(word)); 		//Inserts word at Entry's pos, pushing entry and all following elements down 
							break;	//Break out of method to avoid the base case of adding the word to the end
						} 
					} //After looping through all entries with no matches
					list.add(new IndexEntry(word)); //Add entry to the end of the list 
				}
			}
		} else {System.out.println("Invalid String");}
	}
	
	public void addAllWords(String str, int num) { 
		String[] words = str.split("\\W+"); //should split str into individual word elements w/o punctuation
		if(words.length > 0) {	//HAs elements, and is therefore valid
			for(String word : words) {
				if(!word.equals("") && !word.equals("\\W+")); 	//Not an empty string, and not a separator
					addWord(word, num);
			}
		} else {System.out.println("Invalid String");}	//makes it hear, but doesn't print...
	}
	
	
	//Not sure what this is for
	private int foundOrInster(String word) {
		return 5;
	}

}
