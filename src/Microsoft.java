import java.util.ArrayList;
import java.util.List;

public class Microsoft {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("geeks"); list.add("for"); //list.add("bedbath");list.add("and");list.add("beyond");
		String string = "geeksgeeks";
		
		System.out.println(listOfString(list,string));
	}

	/*
	 * This problem was asked by Microsoft.

Given a dictionary of words and a string made up of those words (no spaces), 
return the original sentence in a list. If there is more than one possible reconstruction, 
return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and 
the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and 
the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] 
or ['bedbath', 'and', 'beyond']. (medium)
COMPLETE
	 */
	public static List<String> listOfString(List<String> list, String string) {
		// base case
		if (list.isEmpty() || string.length() == 0) {
			return null;
		}

		int k = 0;
		List<String> res = new ArrayList<>();
		for (int i = 0; i < string.length(); i++) {
			String substring = string.substring(k, i+1);
			if (list.contains(substring)) {
				res.add(substring);
				k = i+1;
			}
			if (i == string.length()-1 && k != i+1) {
				return null;
			}
		}
		
		return res.size() == 0 ? null : res;
	}
	
	/*
	 * Given a clock time in hh:mm format, determine, to the nearest degree, 
	 * the angle between the hour and the minute hands.
	Bonus: When, during the course of a day, will the angle be zero? (easy) - Microsoft
	 */
	/*
	 * based on a 12-hour clock
	 */
	public static int clock(int hh, int mm) {
		int hr = (hh * 360)/12  + (mm * 360)/(12*60); //<- 3pm  90
		int min = (mm*360)/60;	// <- 0
		int angle = Math.abs(hr-min);
		System.out.println("internal angle: " + angle);
		if (angle > 180) {
			angle = 360 - angle;
		}
		return angle;
	}
	
	/*
	 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

	For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

	You can assume that the messages are decodable. For example, '001' is not allowed.
	 */
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
