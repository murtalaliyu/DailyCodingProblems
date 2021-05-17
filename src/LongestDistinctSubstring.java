import java.util.HashSet;
import java.util.Set;

/*
 * This problem was asked by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb
 */
public class LongestDistinctSubstring {

	public static void main(String[] args) {
		
	}
	
	public static int longDistStr(int k, String s) {
		int longestSubStr = 0;
		
		for (int i = 0; i < s.length(); i++) {
			longestSubStr = Math.max(longestSubStr, backtrack(k, s, i));
		}
		return longestSubStr;
	}
	
	/*
	 * ab 
	 * Set<Character>
	 */
	public static int backtrack(int k, String s, int i) {
		
		for (int j = i; j < s.length()-1; j++) {
			String curr = s.substring(i, j+1);
			Set<Character> set = new HashSet<>();
			char[] currChar = curr.toCharArray();
			for(char ch : currChar) {
				Character temp = ch;
				if(set.size()<k)
					set.add(ch);
				else
					
			}
		}
	}
}
