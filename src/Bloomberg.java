import java.util.HashMap;

public class Bloomberg {

	public static void main(String[] args) {
		String s1 = "paper";
		String s2 = "title";
		
		System.out.println(oneToOne(s1,s2));
	}
	
	/*
	 * This problem was asked by Bloomberg.
		Determine whether there exists a one-to-one character mapping from one string s1 to another s2.
		For example, given s1 = abc and s2 = bcd, return true since we can map a to b, b to c, and c to d.
		Given s1 = foo and s2 = bar, return false since the o cannot map to two characters. (easy)
		COMPLETE, time = O(n), space = O(n)
	 */
	public static boolean oneToOne(String s1, String s2) {
		// base case 
		if (s1.length() != s2.length()) {
			return false;
		}
		
		HashMap<Character,Character> map = new HashMap<>();
		
		int i = 0;
		while (i < s1.length()) {
			if (!map.containsKey(s1.charAt(i))) {
				map.put(s1.charAt(i), s2.charAt(i));
			} else {
				if (map.get(s1.charAt(i)) != s2.charAt(i)) {
					return false;
				}
			}
			i++;
		}
		return true;
	}
}
