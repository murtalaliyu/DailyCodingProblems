import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Palantir {
	public static void main(String[] args) {
//		System.out.println(EgyptianFractions(4,13));
//		List<String> list = new ArrayList<>();
//		
//		String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
//		Collections.addAll(list, array);
//		
//		System.out.println(justifyText(list, 16));
		
//		int[] list = greaterPermutation(new int[] {2,1,3});
//		for (int i : list) {
//			System.out.print(i + ", ");
//		}
		
		System.out.println(h_index(new int[] {50, 40, 33, 23, 12, 11, 8, 5, 1, 0}, 10));
	}
	
	/*
	 * This problem was asked by Palantir.
		In academia, the h-index is a metric used to calculate the impact of a researcher's papers. 
		It is calculated as follows:
		A researcher has index h if at least h of her N papers have h citations each. 
		If there are multiple h satisfying this formula, the maximum is chosen.
		For example, suppose N = 5, and the respective citations of each paper are [4, 3, 0, 1, 5]. 
		Then the h-index would be 3, since the researcher has 3 papers with at least 3 citations.
		Given a list of paper citations of a researcher, calculate their h-index. (easy)
		e.g. [4, 0, 1, 5] = 2, [0, 1, 4, 5]
		COMPLETE. time = O(n), space = O(1)
	 */
	public static int h_index(int[] papers, int N) {
		// base case
		if (papers.length == 0) {
			return 0;
		}
		
		Arrays.sort(papers); // [0, 1, 3, 4, 5]
		
		int count = 1;
		
		for (int i = N-1; i >= 0; i--) {
			if (count < papers[i]) {
				count++;
			} else if(count==papers[i]) {
				return count;
			}else if(count> papers[i]) {
				return count-1;
			}
		}
		return count;
	}
	
	/*
	 * This problem was asked by Palantir.
		Given a number represented by a list of digits, find the next greater permutation of a number, 
		in terms of lexicographic ordering. If there is not greater permutation possible, 
		return the permutation with the lowest value/ordering.
		For example, the list [1,2,3] should return [1,3,2]. The list [1,3,2] should return [2,1,3]. 
		The list [3,2,1] should return [1,2,3].
		Can you perform the operation without allocating extra memory (disregarding the input memory)? (Hard)
	 	COMPLETE
	 */
	public static int[] greaterPermutation(int[] nums) {
		int i = nums.length-2;
		while (i >= 0 && nums[i+1] <= nums[i]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length-1;
			while (nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i+1);
		return nums;
	}
	public static void reverse(int[] nums, int start) {
		int i = start, j = nums.length-1;
		while (i < j) {
			swap(nums, i, j);
			i++; j--;
		}
	}
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
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
