import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Google {
	public static void main(String[] args) {

			//givenPoint();
//		char[] arr = segregateRGB(new char[] {'G', 'B', 'R', 'R', 'B', 'R', 'G'});
//		for (char i : arr) {
//			System.out.print(i + ", ");
//		}
		
//		System.out.println(occursOnce(new int[]{13, 19, 13, 13}));
		
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>(); l1.add(0); l1.add(0);
		List<Integer> l2 = new ArrayList<>(); l2.add(1); l2.add(2);
		List<Integer> l3 = new ArrayList<>(); l3.add(2); l3.add(2);
		List<Integer> l4 = new ArrayList<>(); l4.add(4); l4.add(0);
		List<Integer> l5 = new ArrayList<>(); l5.add(3); l5.add(3);
		List<Integer> l6 = new ArrayList<>(); l6.add(0); l6.add(3);
		list.add(l1); list.add(l2); list.add(l3); list.add(l4); list.add(l5); list.add(l6);
		System.out.println(chessboard_bishops(list, 5));
	}
	
	/*
	 * This problem was asked by Google.

		On our special chessboard, two bishops attack each other if they share the same diagonal. 
		This includes bishops that have another bishop located between them, i.e. bishops can attack through pieces.
		
		You are given N bishops, represented as (row, column) tuples on a M by M chessboard. 
		Write a function to count the number of pairs of bishops that attack each other. 
		The ordering of the pair doesn't matter: (1, 2) is considered the same as (2, 1).
		
		For example, given M = 5 and the list of bishops:
			
		(0, 0)
			
		(1, 2)
			
		(2, 2)
			
		(4, 0)
		
		The board would look like this:
		
		[b 0 0 b 0]
		[0 0 b 0 0]
		[0 0 b 0 0]
		[0 0 0 b 0]
		[b 0 0 0 0]
		
		You should return 2, since bishops 1 and 3 attack each other, as well as bishops 3 and 4. (medium)
		COMPLETED. time = O(n^2), space = O(1)
	 */
	public static int chessboard_bishops(List<List<Integer>> bishops, int M) {
		int count = 0;
		for (List<Integer> bishop1 : bishops) {
			for (List<Integer> bishop2 : bishops) {
				if (bishop1 != bishop2) {
					if (Math.abs(bishop1.get(0) - bishop2.get(0)) == (Math.abs((bishop1.get(1) - bishop2.get(1))))) {
						count++;
					}
				}
			}
		}
		return count/2;
	}
	
	/*
	 * This problem was asked by Google.

		Given an array of integers where every integer occurs three times except for one integer, 
		which only occurs once, find and return the non-duplicated integer.
		
		For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.
		[1,3,3,3,6,6,6], [13,13,13,19]
		Do this in O(N) time and O(1) space. {HARD}
	 */
	public static int occursOnce(int[] arr) {
		
	}
	
	/*
	 * This problem was asked by Google.
		Given a stack of N elements, interleave the first half of the stack with the second
		 half reversed using only one other queue. This should be done in-place.
		Recall that you can only push or pop from a stack, and enqueue or dequeue from a queue.
		For example, if the stack is [1, 2, 3, 4, 5], it should become [1, 5, 2, 4, 3]. 
		If the stack is [1, 2, 3, 4], it should become [1, 4, 2, 3].
		Hint: Try working backwards from the end state. (medium)
	 */
	public static void interleaveStack(Stack<Integer> stack, int N) {
		Queue<Integer> queue = new LinkedList<>();
		
	}
	
	/*
	 * This problem was asked by Google.

	Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all 
	the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.
	
	Do this in linear time and in-place.
	
	For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should 
	become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].{HARD}
	COMPLETE
	 */
	public static char[] segregateRGB(char[] arr) {
		int left = 0, right = arr.length-1;
		
		// move Rs to the left
		while (true) {
			while (arr[left] == 'R' && left < right) {
				left++;
			}
			while (arr[right] != 'R' && left < right) {
				right--;
			}
			if (left >= right) {
				break;
			}
			// swap
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
		
		right = arr.length-1;		// reset right
		
		// move Bs to the right
		while (true) {
			while (arr[left] != 'B' && left < right) {
				left++;
			}
			while (arr[right] == 'B' && left < right) {
				right--;
			}
			if (left >= right) {
				break;
			}
			// swap
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
		
		return arr;
	}
	
	/*
    Design a function which returns true if the given point (having x and y coordinate) 
    forms a square with the previous given points
Eg: (1,5) - false
	(2,5) - false  
	(1,6) - false 
	(2,6) - true <-
	xHAshMAp									yHashMAp
Key  Value										key value 
1     (1,5),  									6     (1,6)
	 */
	public static boolean givenPoint() {
		Scanner sc = new Scanner(System.in).useDelimiter("[,\\s+]");
		
		 while (sc.hasNext()) {
		        if (sc.hasNextInt())
		            System.out.println(sc.nextInt());
		        
		        
		        else 
		            sc.next();
		    }
		
		return false;
		
		// mod4count = 4
//		int xCount = 0, yCount = 0;
//		xList = 1,2
//		yList = 5,6
		
//		
//		int index = 0;
//		while (index < point.length) {
//			int 
//			
//			
//			index++;
//		}
		
	}
	
/*
 * This problem was asked by Google.
You are given an N by M 2D matrix of lowercase letters. Determine the minimum number of columns 
that can be removed to ensure that each row is ordered from top to bottom lexicographically. 
That is, the letter at each column is lexicographically later as you go down each row. 
It does not matter whether each row itself is ordered lexicographically.
For example, given the following table:
cba
daf
ghi
This is not ordered because of the a in the center. We can remove the second column to make it ordered:
ca
df
gi
So your function should return 1, since we only needed to remove 1 column.
As another example, given the following table:
abcdef
Your function should return 0, since the rows are already ordered (there's only one row).
As another example, given the following table:
zyx
wvu
tsr
Your function should return 3, since we would need to remove all the columns to order it. (medium)
COMPLETE
 */
	public static int minCols(char[][] matrix) {
		int count =0;
		for(int i =0; i<matrix[0].length;i++) {
			char prev ='0';
			for(int j =0; j<matrix.length; j++) {
				System.out.println(matrix[j][i]);
				if(prev<matrix[j][i])
					prev = matrix[j][i];
				else {
					count++;
					continue;
				}
					
			}
		}
		return count;
	}
	
	/*
	 * This problem was asked by Google.

Suppose we represent our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext


The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext


The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.

Note:

The name of a file contains at least a period and an extension.

The name of a directory or sub-directory will not contain a period. {HARD}

	 */
	static int longestAbsPath(String s) {
		String prev = "";
		int count = 0;
		
		char[] arr = s.toCharArray();
		
		for (char c : arr) {
			System.out.println(c);
		}
		
		return 0;
	}
	
	/*
	 * This problem was asked by Google.
		Given k sorted singly linked lists, 
		write a function to merge all the lists into one sorted singly linked list. (medium)
	 */
	public static ListNode merge(ListNode[] lists) {
		PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> {
	        if(a.value>b.value) {
	            return 1;
	        } else if(a.value<b.value) {
	            return -1;
	        }
	        return 0;
	    });
		
		// add to heap
		for (ListNode l : lists) {
			if (l != null) {
				heap.add(l);
			}
		}
		
		ListNode dummy = new ListNode();
        ListNode head = dummy;
		
		while (!heap.isEmpty()) {
			ListNode curr = heap.poll();
			System.out.println("curr: " + curr.value);
			while (curr != null) {
				dummy.next = curr;
				if (curr.next != null) {
					heap.add(curr.next);
				}
				dummy = dummy.next;
			}
		}
		
		return head.next;
	}
	
	public static void oldTests() {
//		char[][] matrix = {
//		{'c', 'b', 'a'},
//		{'d', 'a', 'f'},
//		{'g', 'h', 'i'}
//};
//char[][] matrix = {
//		{'a', 'b'},
//		{'c', 'g'},
//		{'b', 'f'}};
////System.out.println((int)'z');
//System.out.println(minCols(matrix));

//longestAbsPath("dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext");

ListNode l1 = new ListNode(5); l1.next = new ListNode(6); l1.next.next = new ListNode(7);  
ListNode l2 = new ListNode(1); l2.next = new ListNode(4); l2.next.next = new ListNode(8); 
ListNode l3 = new ListNode(2); l3.next = new ListNode(12); l3.next.next = new ListNode(24); 

ListNode[] lists = new ListNode[3];
lists[0] = l1;lists[1] = l2;lists[2] = l3;

ListNode res = merge(lists);

while (res != null) {
	System.out.print(res.value + ", ");
	res = res.next;
}
	}
}

class ListNode {
	int value;
	ListNode next;
	
	public ListNode() {}
	
	public ListNode(int value) {
		this.value = value;
		next = null;
	}
}
