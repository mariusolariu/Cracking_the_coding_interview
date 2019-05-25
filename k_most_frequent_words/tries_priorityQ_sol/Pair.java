import java.util.Objects;

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


	@Override
	public boolean equals(Object other){
		if (this == other) return true;

		if (!(other instanceof Pair)) return false;

		Pair o = (Pair) other;

		return o.word.equals(this.word);
	}

	@Override
	public int hashCode(){
		return Objects.hash(word);
	}
}
