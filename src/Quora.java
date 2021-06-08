
public class Quora {
	
	public static void main(String[] args) {
		System.out.println("final: " + fewPalindrome("leetcode"));
	}

	/*
	 * This problem was asked by Quora.

	Given a string, find the palindrome that can be made by inserting the fewest number of characters 
	as possible anywhere in the word. If there is more than one palindrome of minimum length that can be made, 
	return the lexicographically earliest one (the first one alphabetically).
	
	For example, given the string "ecrace", you should return "ecarace", 
	since we can add three letters to it (which is the smallest amount to make a palindrome). 
	There are seven other palindromes that can be made from "race" by adding three letters, 
	but "ecarace" comes first alphabetically.
	
	As another example, given the string "google", you should return "elgoogle".{MEDIUM}
	
	 */
	public static String fewPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		
		int start=0, end=sb.length()-1;
		while (start <= end) {
			if (sb.charAt(start) != sb.charAt(end)) {
				sb.insert(start, sb.charAt(end));
			}
			start++; end = sb.length()-1-start;
		}
		
		return sb.toString();
	}
}
