import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xpath.internal.operations.String;

/*
 * 		// integer to string
		String x = Integer.toString(5);
		// string to integer
		int y = Character.getNumericValue(x.charAt(0));
		System.out.println(y);
 */

public class Facebook {
	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(3); list.add(7); list.add(15); list.add(1); list.add(9); list.add(6); 
//		System.out.println(pickRandom(list));
		
	//	int[] arr = {2, 1, 2};
//		int[] arr = {3, 0, 1, 2};
//		System.out.println(waterTrapped(arr));
		
//		System.out.println(maxProfit(new int[]{100, 180, 260, 310, 40, 535, 695}));
		
	}
	
	/*
	 * This problem was asked by Facebook.
		Suppose you are given two lists of n points, one list p1, p2, ..., pn on the line y = 0 
		and the other list q1, q2, ..., qn on the line y = 1. Imagine a set of n line segments 
		connecting each point pi to qi. Write an algorithm to determine how many pairs of the line 
		segments intersect. (Easy)
	 */
	public static int pairsIntersect(List<Integer> p, List<Integer> q) {
		// base case 1: p is empty, // base case 2: p.size != q.size 
		if (p.size() == 0 || p.size() != q.size()) {
			return 0;
		}
		
		int p0 = p.get(0);
		int q0 = q.get(0);
		for (int i = 1; i < p.size(); i++) {
			int pi = p.get(i);
			int qi = q.get(i);
			
			
		}
	}
	
	/*
	 * This problem was asked by Facebook.

		Given a array of numbers representing the stock prices of a company in chronological order, 
		write a function that calculates the maximum profit you could have made from buying and selling 
		that stock once. You must buy before you can sell it.
		
		For example, given [9, 11, 8, 5, 7, 10], you should return 5, 
		since you could buy the stock at 5 dollars and sell it at 10 dollars.{Easy}
		COMPLETE, time = O(n^2), space = O(1)
	 */
	public static int maxProfit(int[] prices) {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		int difference = 0;
		
		for (int i = 0; i < prices.length; i++) {
			for (int j = i+1; j < prices.length; j++) {
				if (prices[j] - prices[i] > difference) {
					difference = prices[j] - prices[i];
				}
			}
		}
		
		return difference;
	}
	
	/*
	 * This problem was asked by Facebook.

You are given an array of non-negative integers that represents a two-dimensional elevation map 
where each element is unit-width wall and the integer is the height. Suppose it will rain and all 
spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, 
and 3 in the fourth index (we cannot hold 5 since it would run off to the left), 
so we can trap 8 units of water. [medium]
	 */
	static int res = 0;
	public static int waterTrapped(int[] arr) {
		// edge case
		if (arr.length < 2) {
			return 0;
		}
		
		int tracker = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[tracker] > arr[i]) {
				//res += arr[tracker] - arr[i];
				continue;
			} else {
				System.out.println("last index of subarray: "+ i);
				waterTrappedHelper(Arrays.copyOfRange(arr, tracker, i));
				tracker = i;
			}
		}
		
		return res;
	}
	public static void waterTrappedHelper(int[] subArr) {
//		int start;
		for(int i =1; i<subArr.length; i++) {
			int diff =  subArr[0] - subArr[i];
			res += subArr[0] - subArr[i];
			System.out.println("Diff: "+ diff);
		}
		
	}
	

	/*
	 * This problem was asked by Facebook.
Given a stream of elements too large to store in memory, 
pick a random element from the stream with uniform probability. (medium)
COMPLETE
	 */
	public static int pickRandom(ArrayList<Integer> list) {
		int res = 0;
		double biggest = 0;
		
		for (int i = 0; i < list.size(); i++) {
			double randomNum = Math.random();
			if (randomNum > biggest) {
				biggest = randomNum;
				res = list.get(i);
			}
		}
		return res;
	}
	
	/*
	 * In Ancient Greece, it was common to write text with the 
	 * first line going left to right, the second line going right to left, 
	 * and continuing to go back and forth. This style was called "boustrophedon".
	Given a binary tree, write an algorithm to print the nodes in boustrophedon order.
	For example, given the following tree:
	       1
	    /     \
	  2         3
	 / \       / \
	4   5     6   7
	You should return [1, 3, 2, 4, 5, 6, 7].
	 */
	public static HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	public static void bfs(binaryTree root, int depth) {
		if (root == null) {
			return;
		}
		
		if (!map.containsKey(depth)) {
			map.put(depth, new ArrayList<Integer>());
		}
		
		map.get(depth).add(root.data);
		
		bfs(root.left, depth+1);
		bfs(root.right, depth+1);
		
		return;
	}
	public static void zigzag() {
		for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
			int key = e.getKey();
						
			// if even
			if (key % 2 == 0) {
				ArrayList<Integer> value = e.getValue();
				for (int i = 0; i < value.size(); i++) {
					System.out.print(value.get(i) + "\t");
				}
				System.out.println();
			}
			
			// if odd
			else if (key % 2 != 0)
			{
				ArrayList<Integer> value = e.getValue();
				//System.out.println("odd value: " + value);
				for (int i = value.size()-1; i >= 0; i--) {
					System.out.print(value.get(i) + "\t");
				}
				System.out.println();
			}
			
		}
	}
	
	/*
	 * An XOR linked list is a more memory efficient doubly linked list. 
	 * Instead of each node holding next and prev fields, 
	 * it holds a field named both, which is an XOR of the next node and the previous node. 
	 * Implement an XOR linked list; it has an add(element) which adds the element to the end, 
	 * and a get(index) which returns the node at index.
	 */
	static XORLList head, prev, next;
	static void add(int data, int addr) {
		//int xor = 200^600;
		XORLList node = new XORLList(data);
		if (head == null) {
			head = node;
		} else {
			XORLList n = head;
			prev = null;
			while (n.both != null) {
				int temp = n.both ^ getnt(prev);
				prev = n;
			}
			n.next = node;
		}
		
		prev = node.both;
		
	}
	static XORLList get() {
		
	}
	
	/*
	 * This problem was asked by Facebook
	 * 
	 * Given a number in Ronam numeral format, convert it to decimal.
	 * 
	 * The values of Roman numerals are as follows:
	 * {'M', 1000},
	 * {'D', 500},
	 * {'C', 100},
	 * {'L', 50},
	 * {'X', 10},
	 * {'V', 5},
	 * {'I', 1}
	 * 
	 * In addition, note that the Roman numeral system uses subtractive notation for numbers such as IV and XL.
	 * 
	 * For the input XIV, for instance, you should return 14. (Medium)
	 * 
	 * COMPLETE: time = O(n), space = O(1) <- if map is already given
	 */
	static HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();
	public static int romanNumeral(String roman) {
		romanMap.put('M', 1000); romanMap.put('D', 500); romanMap.put('C', 100); romanMap.put('L', 50); romanMap.put('X', 10); romanMap.put('V', 5); romanMap.put('I', 1);
		
		// edge case 1: empty string
		if (roman.length() == 0) {
			return 0;
		}
		// edge case 2: invalid string
		for (int i = 0; i < roman.length(); i++) {
			char currChar = roman.charAt(i);
			if (currChar != 'M' && currChar != 'D' && currChar != 'C' && currChar != 'L' && currChar != 'X' && currChar != 'V' && currChar != 'I') {
				return 0;
			}
		}
		
		// start from end to check for subtractive notation
		char prev = 0; int sum = 0;
		for (int i = roman.length()-1; i >= 0; i--) {
			char currChar = roman.charAt(i);
			
			if (prev == 0) {
				sum += romanMap.get(currChar);
			} else {
				if (romanMap.get(currChar) < romanMap.get(prev)) {
					sum -= romanMap.get(currChar);
				} else {
					sum += romanMap.get(currChar);
				}
			}
			
			prev = currChar;
		}
		
		return sum;
	}
	
	/*
	 * This problem was asked by Facebook
	 *  Look and Say
		Implement a function that outputs the Look and Say sequence:
		1
		11
		21
		1211
		111221
		312211
		13112221
		1113213211
		31131211131221
		13211311123113112211
		
		COMPLETE: time = O(N), space = O(1)
	 */
	public static String lookAndSay(int input) {
		// base case 1: input <1?
		if (input < 1) {
			return "10";
		}
		// base case 2: input = 1
		if (input == 1) {
			return "1" + input;
		}
		
		// convert int to string
		String stringInput = Integer.toString(input);
		String output = "";
		
		// keep track of previous and count
		char prev = 0; int count = 1;
		
		// iterate over stringInput
		for (int i = 0; i < stringInput.length(); i++) {
			char c = stringInput.charAt(i);
			if (prev == 0) {
				// do nothing
			} else {
				if (prev == c) {
					count++;
				} else {
					output += Integer.toString(count) + prev;
					count = 1;
				}
			}
			
			prev = c;
		}
		output += Integer.toString(count) + prev;
		
		return output;
	}
	
	/*
	 * This problem was asked by Facebook
	 * Write a function that returns whether two words are exactly "one edit" away using the following signature:
		bool OneEditApart(string s1, string s2);
		An edit is:
		Inserting one character anywhere in the word (including at the beginning and end)
		Removing one character
		Replacing one character
		Examples:
		OneEditApart("cat", "dog") = false
		OneEditApart("cat", "cats") = true
		OneEditApart("cat", "cut") = true
		OneEditApart("cat", "cast") = true
		OneEditApart("cat", "at") = true
		OneEditApart("cat", "act") = false
		
		COMPLETE: time = O(N) due to 1 for loop, space = O(N) due to hash-map
	 */
	public static boolean OneEditApart(String s1, String s2) {
		// edge case 1: empty strings
		if (s1.isEmpty() || s2.isEmpty()) {
			return false;
		}
		// edge case 2: length of one string is at least 2 more than the other
		if (Math.abs(s1.length()-s2.length()) > 1) {
			return false;
		}
		
		int s1Length = s1.length();
		int s2Length = s2.length();
		
		// populate smaller and bigger string
		String smallerString = "", biggerString = "";
		if (s1Length <= s2Length) {
			smallerString = s1;
			biggerString = s2;
		}  else {
			smallerString = s2;
			biggerString = s1;
		}
		System.out.println("smaller string: " + smallerString);
		System.out.println("bigger string: " + biggerString);
		
		// populate map with string of smaller length
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		map = populateMap(map, smallerString);
		
		// iterate over bigger string and check if count > 1
		int containedCount = 0, inplaceCount = 0;
		for (int i = 0; i < biggerString.length(); i++) {
			char currChar = biggerString.charAt(i);
			// not contained
			if (!map.containsValue(currChar)) {
				containedCount++;
				if (containedCount > 1) {
					return false;
				}
			}
			// not in-place
			if (s1Length == s2Length) {
				if (currChar != smallerString.charAt(i)) {
					inplaceCount++;
					if (inplaceCount > 1) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public static HashMap<Integer, Character> populateMap(HashMap<Integer, Character> map, String s) {
		for (int i = 0; i < s.length(); i++) {
			map.put(i, s.charAt(i));
		}
		return map;
	}
	
}

class binaryTree {
	int data;
	binaryTree left;
	binaryTree right;
	
	binaryTree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class XORLList {
	int data;
	XORLList both;
	
	XORLList(int data) {
		this.data = data;
		both = null;
	}
}
