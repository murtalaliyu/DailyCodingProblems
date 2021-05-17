import java.util.ArrayList;

/*
	Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
	For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
	Bonus: Can you do this in one pass?
 */

public class GetProductExcludeIndex {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1); list.add(2); list.add(3); list.add(4); list.add(5);
		//list.add(3); list.add(2); list.add(1);
		System.out.println("prodList v1: " + productArrv1(list));
		
		System.out.println("prodList v2: " + productArrv2(list));
	}
	
	/*
	 * Given an array of integers, return a new array such that each element at
	 *  index i of the new array is the product of all the numbers in the 
	 *  original array except the one at i.

		For example, if our input was [1, 2, 3, 4, 5], 
		the expected output would be [120, 60, 40, 30, 24]. 
		If our input was [3, 2, 1], the expected output would be [2, 3, 6].
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
