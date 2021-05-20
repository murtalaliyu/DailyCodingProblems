import java.util.ArrayList;

public class Palantir {
	public static void main(String[] args) {
		System.out.println(EgyptianFractions(4,13));
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