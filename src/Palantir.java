import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Palantir {
	public static void main(String[] args) {
//		System.out.println(EgyptianFractions(4,13));
		List<String> list = new ArrayList<>();
		
		String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
		Collections.addAll(list, array);
		
		System.out.println(justifyText(list, 16));
	}
	
	/*
	 * Write an algorithm to justify text. Given a sequence of words and an integer line length k, 
	 * return a list of strings which represents each line, fully justified.

More specifically, you should have as many words as possible in each line. 
There should be at least one space between each word. Pad extra spaces when necessary so that 
each line has exactly length k. Spaces should be distributed as equally as possible, 
with the extra spaces, if any, distributed starting from the left.

If you can only fit one word on a line, then you should pad the right-hand side with spaces.

Each word is guaranteed not to be longer than k.

For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"]
 and k = 16, you should return the following:

["the  quick brown", # 1 extra space on the left
"fox  jumps  over", # 2 extra spaces distributed evenly
"the   lazy   dog"] # 4 extra spaces distributed evenly

{medium}
	 */
	public static List<String> justifyText(List<String> words, int k) {
		int totalLength = 0, count =0;
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		
		for (String s : words) {
			int length = s.length();
			//count += (length+1);
			if ((totalLength+length+1) > k) {
				count =1;
				totalLength = length+1;
				res.add(sb.toString());
				sb = new StringBuilder();
				sb.append(s+" ");
				System.out.println("in if: " + res + ". Count = " + totalLength);
			} else {
				totalLength += length+1;
				count+=1;
				sb.append(s+" ");
				System.out.println("in else: " + res + ". Count = " + totalLength);
			}
			
			
		}
		res.add(sb.toString());
		
		return res;
	}

	/*
	 * This problem was asked by Palantir.
The ancient Egyptians used to express fractions as a sum of several terms 
where each numerator is one. For example, 4 / 13 can be represented as 1 / 4 + 1 / 18 + 1 / 468.
Create an algorithm to turn an ordinary fraction a / b, where a < b, into an Egyptian fraction. (easy)
COMPLETE (brute force)
	 */
	static ArrayList<ArrayList<Integer>> EgyptianFractions(int a, int b) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		// base case
		if (a >= b)
			return list;
		
		for (int i = 0; i < a; i++) {
			ArrayList<Integer> currList = new ArrayList<Integer>();
			currList.add(1); currList.add(b);
			list.add(currList);
		}
		
		return list;
		
		/*
		 *  // We reach here dr > nr and dr%nr
        // is non-zero. Find ceiling of
        // dr/nr and print it as first
        // fraction
        int n = dr / nr + 1;
        System.out.print("1/" + n + " + ");
 
        // Recur for remaining part
        printEgyptian(nr * n - dr, dr * n);
		 */
	}
}

// 4/13 -> 1/13 + 1/13 + 1/13 + 1/13
/*
	1,13
	1,13
*/