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
}
