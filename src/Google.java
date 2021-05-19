
public class Google {
	public static void main(String[] args) {
//		char[][] matrix = {
//				{'c', 'b', 'a'},
//				{'d', 'a', 'f'},
//				{'g', 'h', 'i'}
//		};
		char[][] matrix = {
				{'a', 'b'},
				{'c', 'g'},
				{'b', 'f'}};
		//System.out.println((int)'z');
		System.out.println(minCols(matrix));
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
}
