import java.util.HashMap;

/*
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
 */
public class DecodeMsg {
	public static void main(String[] args) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for (int i = 97; i < 123; i++) {
			map.put(Character.valueOf((char) i), i-96);
		}
		System.out.println("map: " + map);
		
		System.out.println(findWays("5370"));
	}
	
	static int count = 0;
	static int findWays(String input) {
		// base case
		if (input.length() == 0) {
			return 0;
		}
		
//		for (int i = 0; i < input.length(); i++) {
			int i =0;
			String currSubstr = input.substring(i, i+1);
			System.out.println("currSubstr: " + currSubstr + ", i: " + i);
			if (Integer.valueOf(currSubstr) <= 26) {
				if (i == input.length()-1) {
					count++;
					//return count;
				}
				i++;
			} else {
				i++;
			}
//		}
		
		return count;
	}
	
	static void backtracker(String input, int i) {
		
	}
}
