package day21;

public class Dictionary {

	private String word;
	private String speech;
	private String meaning;
	
	public Dictionary(String word, String speech, String meaning) {
		this.word = word;
		this.speech = speech;
		this.meaning = meaning;
	}

	@Override
	public String toString() {
		return "단어 : " + word + ", 품사 : " + speech + ", 뜻 : " + meaning;
	}

	public void update(String speech, String meaning) {
		this.speech = speech;
		this.meaning = meaning;
	}
	
	
}
