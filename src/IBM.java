import java.util.HashMap;

public class IBM {

	public static void main(String[] args) {
		
	}
	
	/*
	 * This problem was asked by IBM.
		Given a string with repeated characters, rearrange the string so that no two adjacent 
		characters are the same. If this is not possible, return None.
		For example, given "aaabbc", you could return "ababac". Given "aaab", return None. (easy)
	 */
	public static String rearrange(String input) {
		StringBuilder sb = new StringBuilder(input);
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
		for (int i = 0; i < input.length(); i++) {
			if (!map.containsKey(input.charAt(i))) {
				map.put(input.charAt(i), 1);
			} else {
				if (map.get(input.charAt(i)) > input.length()/2) {
					return "none";
				}
				map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
			}
		}
	}
}

// a=4, b=2, c=1
// ababacab