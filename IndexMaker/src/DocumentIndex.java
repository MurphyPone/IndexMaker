import java.util.ArrayList;

public class DocumentIndex extends ArrayList<IndexEntry> { //Represents the entire index for the document, list of all its index entries	
	public DocumentIndex() {
		super();
	}
	
	public DocumentIndex(int size) {
		super(size);
	}
	
	public void addWord(String word, int lnNum) { 
		int index = foundOrInserted(word);
		
		if(index > -1) {
			IndexEntry entry = this.get(index);
			this.add(lnNum, entry);
		} else { //index == -1
			System.out.println("Inserted in helper......." + index);
		}
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
			int i = 0;
			if(this.size() > 0) {
				String lWord = this.get(i).getWord();
				while(i < this.size() && word.compareTo(lWord) > 0) {	//While i is in bounds and greater than the preceeding word
					i++;
					if(i < this.size())	//check bounds
						lWord = this.get(i).getWord();	//reset value to next word
				}
				
				if(!word.toLowerCase().equals(this.get(i))) {	//Entry DNE at this spot
					this.add(i, new IndexEntry(word));	//create a new one 
				} 
				return i; //return the index of the word 
			} 
		}
		System.out.println(word);
		return -1;	//invalid 
	}

}
