import java.util.ArrayList;

public class Amazon {

	/*
	 * This problem was asked by Amazon.

	Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

	For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb
	 */
	public static void x() {
		
	}
	
	/*
	 * Given a list of integers S and a target number k, 
	 * write a function that returns a subset of S that adds up to k. 
	 * If such a subset cannot be made, then return null.
		Integers can appear more than once in the list. You may assume all numbers in the list are positive.
		For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
	 */
	static ArrayList<Integer> subsetAdd(ArrayList<Integer> list, int k) {
		int temp = 0;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) <= k) {
				temp = k;
			}
		}
	}
	
	/*
	 * Given an array of integers, return a new array such that each element at
	 *  index i of the new array is the product of all the numbers in the 
	 *  original array except the one at i.

		For example, if our input was [1, 2, 3, 4, 5], 
		the expected output would be [120, 60, 40, 30, 24]. 
		If our input was [3, 2, 1], the expected output would be [2, 3, 6].
		COMPLETE
	 */
	// O(n^2)
	public static ArrayList<Integer> productArrv1(ArrayList<Integer> list) {
		ArrayList<Integer> prodList = new ArrayList<Integer>();
		
		for (int i = 0; i < list.size(); i++) {
			int product = 1;
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					product *= list.get(j);
				}
			}
			prodList.add(product);
		}
		
		return prodList;
	}
	// O(n)
	public static ArrayList<Integer> productArrv2(ArrayList<Integer> list) {
		ArrayList<Integer> prodList = new ArrayList<Integer>();

		// first get product
		int product = 1;
		for (int i : list) {
			product *= i;
		}
		
		// second: divide product by each index
		for (int i : list) {
			prodList.add(product / i);
		}
		
		return prodList;
	}
	
}
