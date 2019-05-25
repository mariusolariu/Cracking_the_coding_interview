public class Pair{
	String word;
	int frequency;

	public Pair(){}

	public Pair(String word, int freq){
		this.word = word;
		this.frequency = freq;
	}

	@Override
	public String toString(){
		return word + " " + frequency;
	}
}
