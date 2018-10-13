import java.util.*;

public class Main{

	public static boolean isChar(char c){
		return ((c >= 'a') && (c <= 'z')) ||
			   ((c >= 'A') && (c <= 'Z'));
    }
	
	public static String urlIFY(String s){
		int len = s.length();		
		int state = (s.charAt(0) == ' ') ? 0 : 1;
		int pos_start = 0;
		int pos_end = 0;
		int old_state = 0;
		StringBuilder urlfied = new StringBuilder("");

		for (int i=0; i < len; i++){
			char c = s.charAt(i);

			switch (state){

				case 0:
					old_state = state;

					if (c == ' '){
						state = 0;
					}
					else{
						state = 1;
						urlfied.append(c);
					}
					
					break;

				case 1:		
				
					if (old_state == 2){
					    for (int j = pos_start; j < pos_end; j++){
							urlfied.append("%20");
						}
						urlfied.append(s.charAt(i-1));
					}

					old_state = state;
	
					if (c == ' '){
						pos_start = i;
						state = 2;
					}else{
						urlfied.append(c);
						state = 1;
					}

				   break;

				case 2:
					old_state = state;

					if (c == ' '){
						state = 2;
					}else{
						state = 1;
						pos_end = i;
					}

					break;

			}
		}

		return urlfied.toString();
	}

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();

		System.out.println("\n Urlfied: " + urlIFY(input));
	}

}
