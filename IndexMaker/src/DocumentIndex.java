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
	
	public void addWord(String word, int lnNum) { 
		if(foundOrInserted(word) >-1) //TODO fix with var
			list.get(foundOrInserted(word)).add(lnNum);
	}
	
	public void addAllWords(String str, int lnNum) { 
		String[] words = str.split("\\W+"); //should split str into individual word elements w/o punctuation
		
		if(words.length > 0) {	//HAs elements, and is therefore valid
			for(String word : words) {
				if(!word.equals("") ); 	//Not empty
					addWord(word, lnNum);
			}
		} else {System.out.println("Invalid String");}	//makes it here, but doesn't print...
	}
	
	
	//Not sure what this is for
	private int foundOrInserted(String word) {	//Returns the index of the place it belongs
		if(word != "") {		//Is a valid string
			for(int i = 0; i < list.size(); i++) {	//"traverses this DocumentIndex"
				IndexEntry entry = list.get(i);	//Temp var for entry[i]
				
				if(entry.getWord().toLowerCase().equals(word.toLowerCase() )) {	//An entry exists for the given word
					return i;	//Returns index of the word that matches
				} else {	 //Entry does not already exist
					for(int j = 0; j < list.size(); j++) {	//Unnecessary loop?
						if(word.toLowerCase().compareTo(entry.getWord().toLowerCase()) < 0) {	//word precedes entry alphabetically
							list.add(j, new IndexEntry(word)); 		//Inserts word at Entry's pos, pushing entry and all following elements down 
							return j; 	//Break out of method to avoid the base case of adding the word to the end
						} 
					} //After looping through all entries with no matches
					System.out.println("got here");
					list.add(new IndexEntry(word)); //Add entry to the end of the list 
				}
			}
		} else {System.out.println("Invalid String");}
		return -1;
	}

}
