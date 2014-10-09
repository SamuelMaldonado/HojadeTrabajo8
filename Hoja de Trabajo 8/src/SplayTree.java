

public class SplayTree implements WordSet{

	private SetSplayTree base;
	
	public SplayTree(){
		base = new SetSplayTree();
	}
	
	
	public void add(Word wordObject) {
		base.insert(wordObject);
		
	}

	
	public Word get(Word word) {

		return (Word)base.find(word);
	}

}
