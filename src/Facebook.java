import java.util.ArrayList;

public class Facebook {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3); list.add(7); list.add(15); list.add(1); list.add(9); list.add(6); 
		System.out.println(pickRandom(list));
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
}


// 64, 32 3,,5,1,8,9
//     .5, 
