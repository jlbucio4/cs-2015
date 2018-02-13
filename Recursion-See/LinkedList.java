
/**
 * @author jbucio4
 *
 */
public class LinkedList {
	// Get and Set methods are NOT necessary!

	private LinkedList next; 	
	private final String word;

	/** Constructs this link.
	 * @param word ; a single word (never null).
	 * @param next ; the next item in the chain (null, if there are no more items).
	 */
	public LinkedList(String word, LinkedList next) {
		this.word = word;
		this.next = next;
	}

	/**
	 * Converts the entire linked list into a string representation.
	 */
	public String toString() {
		if (next == null)
			return word;// BASE CASE; no more recursion required

		// Recursive case:
		String restOfString = next.toString(); // Forward Recursion
		return word + ";" + restOfString;
	}

	/**
	 * Returns the number of entries in the linked list.
	 * @return number of entries.
	 */
	public int getCount() {
		if (next == null)
			return 1; // BASE CASE; no more recursion required!

		// Recursive case:
		return 1 + next.getCount(); // Forward recursion
	}
	
	/** Creates a new LinkedList entry at the end of this linked list.
	 * Recursively finds the last entry then adds a new link to the end.
	 * @param word
	 */
	public void append(String word) {
		if (next == null){
			LinkedList k = new LinkedList(word,null);
			next = k;
			return;
		}
		next.append(word);
		return;
	}
	/**
	 * Recursively counts the total number of letters used.
	 * 
	 * @return total number of letters in the words of the linked list
	 */
	public int getLetterCount() {
		// returns the total number of letters. word1.length() +
				// word2.length()+...
				// "A" -> "CAT" -> null returns 1 + 3 = 4.
		if (next == null){
			return word.length();
		}
		return word.length() + next.getLetterCount(); 
	}

	/**
	 * Recursively searches for and the returns the longest word.
	 * @return the longest word i.e. word.length() is maximal.
	 */
	public String getLongestWord() {
		// recursive searches for the longest word
		if (next == null){
			return word;
		}
		String w = next.getLongestWord();
			if (w.length() > word.length()){
			return w;
			}
		return word;
	}

	/** Converts linked list into a sentence (a single string representation).
	* Each word pair is separated by a space.
	* A period (".") is appended after the last word.
	* The last link represents the last word in the sentence.*/
	public String getSentence() {
		if (next == null){
			return this.word + ".";
		}
		return this.word + " " + next.getSentence();
	}
	
	/**
	 * Converts linked list into a sentence (a single string representation).
	 * Each word pair is separated by a space. A period (".") is appended after
	 * the last word. The last link represents the first word in the sentence
	 * (and vice versa). The partialResult is the partial string constructed
	 * from earlier links. This partialResult is initially an empty string. 
	 */
	public String getReversedSentence(String partialResult) {
		if (next == null){
			return this.word + ".";
		}
		partialResult = next.getReversedSentence(partialResult).substring(0,next.getReversedSentence(partialResult).length()-1) + " " + this.word; 
		return partialResult + ".";
	}
	

	/** Creates a linked list of words from an array of strings.
	 * Each string in the array is a word. */
	public static LinkedList createLinkedList(String[] words) {
		LinkedList list = new LinkedList(words[0], null);
			for (int i = 1; i < words.length; i++){
			list.append(words[i]);
			}
		return list;
		// Hint: This is a wrapper method. You'll need to create your
		// own recursive method.
		// Yes this is possible _without_ loops!
	}

	/**
	 * Searches for the following word in the linked list. Hint: use .equals not ==
	 * to compare strings.
	 * 
	 * @param word
	 * @return true if the linked list contains the word (case sensivitive)
	 */
	public boolean contains(String word){
		if (next == null){
				if (this.word.equals(word)){
					return true;
				}
			return false; 
		}
		
		if (this.word.equals(word)){
			return true;
		} 
		
			return ((false) || (next.contains(word))); 
		
	}
	/** Recursively searches for the given word in the linked list.
	 * If this link matches the given word then return this link.
	 * Otherwise search the next link.
	 * If no matching links are found return null.
	 * @param word the word to search for.
	 * @return The link that contains the search word.
	 */
	public LinkedList find(String word) {
		
		if (next == null) {
			if (this.word.equals(word)){
				return this;
			}
				return null; 
		}
		
			if (this.word.equals(word)){
				return this;
			}
		
		return next.find(word); 

	}

	/**
	 * Returns the last most link that has the given word, or returns null if
	 * the word cannot be found.
	 * Hint: Would forward recursion be useful?
	 * @param word the word to search for.
	 * @return the last LinkedList object that represents the given word, or null if it is not found.
	 */
	public LinkedList findLast(String word){
		if (next == null){
				if (this.word.equals(word)){
					return this;
				}
				return null; 
		}
		if ((next.findLast(word) == null) && (this.word.equals(word))){
				return this; 
		}
			return next.findLast(word); 
		
	}

	public LinkedList insert(String string){
		if ((next == null) && (string.compareTo(word) > 0)){
			LinkedList in = new LinkedList(string, null);
			next = in;
			return this; 
		}
			if(string.compareTo(word) <= 0){
				LinkedList t = new LinkedList(string, this);
				return t; 
			}
			if((string.compareTo(word) > 0) && (string.compareTo(next.word) <= 0)){
				LinkedList t = new LinkedList(string, next);
				next = t;
				return this;
			}
				else{
					next.insert(string); 
					return this;
				}
	}

}
