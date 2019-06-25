import java.util.List;
import java.util.ArrayList;

 public class Solution{
	 	private static final char OPEN_P = '('; 
	 	private static final char CLOSE_P = ')'; 

	 	public Solution(){
		}

		private void addCombination(List<String> list, String comb){
			if (!list.contains(comb)) list.add(comb);
		}

		public List<String> generateParantheses(int n){

			if (n <= 0) return new ArrayList<>();
			else if (n == 1){
				String simple = "()";
				ArrayList<String> parantheses = new ArrayList<String>();
				parantheses.add(simple);

				return parantheses;
			}

			List<String> oldParantheses = generateParantheses(n - 1);
			List<String> newParantheses = new ArrayList<String>();

			for (String p : oldParantheses){
				for (int i = 0; i < p.length(); i++){
					char currChar = p.charAt(i);

					if (currChar == OPEN_P){
						String newComb = p.substring(0, i) + OPEN_P + currChar + CLOSE_P + p.substring(i+1);
						
						addCombination(newParantheses, newComb);
					}
				}

				String newComb = p + "()";
				addCombination(newParantheses, newComb);

			}
			

			return newParantheses;	
		}

		public static void main(String[] args){
			Solution sol= new Solution();

			List<String> p = sol.generateParantheses(3);

			System.out.println("Total combinations: " + p.size());
			for (String s : p){
				System.out.print(s + " ");
			}
		}

 } 

