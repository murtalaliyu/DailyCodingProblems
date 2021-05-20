import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Twitter {
	public static void main(String[] args) {
		record(1); record(2); record(3); record(4); record(5); record(6);  
		System.out.println("log: " + log);
		System.out.println("ith element: " + get_ith_last_element(0));
	}

	/*
	 * This problem was asked by Twitter.

You run an e-commerce website and want to record the last N order ids in a log. 
Implement a data structure to accomplish this, with the following API:
	
record(order_id): adds the order_id to the log
	get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.

You should be as efficient with time and space as possible.(easy)
COMPLETE

  // N: 5
  // q: 6 5 4 3 2 <- front of q
	 */
	private static int N = 5;
	private static Queue<Integer> log = new LinkedList<>();
	
	static void record(int id) {
		if (log.size() >= N) {
			log.poll();
		}
		log.add(id);
		return;
	}
	
	static int get_ith_last_element(int i) {
		Iterator iter = log.iterator();
		int j = 0;
		while (iter.hasNext()) {
			int last = (int)iter.next();
			//System.out.println("at:" + j + ", element:" + last);
			if (i == (log.size()-j)) {
				return last;
			}
			j++;
		}
		return -1;
	}
}
