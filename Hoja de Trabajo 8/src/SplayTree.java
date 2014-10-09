import java.util.ArrayList;

public class SplayTree implements WordSet{

	private ArrayList<Word> base;
	
	public SplayTree(){
		base = new ArrayList<Word>();
	}
	
	
	public void add(Word wordObject) {
		base.add(wordObject);
		
	}

	
	public Word get(Word word) {
		int index = base.indexOf(word);
		if(index == -1) return null;
		return base.get(index);
	}

}
