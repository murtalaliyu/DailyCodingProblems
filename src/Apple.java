import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class Apple {

	public static void main(String[] args) throws InterruptedException {
//		schedule(5);
	}
	
	/*
	 * This question was asked by Apple.
		Given a binary tree, find a minimum path sum from root to a leaf.
		For example, the minimum path in this tree is [10, 5, 1, -1], which has sum 15. (Easy)
		  10
		 /  \
		5    5
		 \     \
		   2    1
		       /
		     -1
			 */
	static int result = 0;
	public static int minPath(TreeNode root) {
		int minPath = 0;
		return Math.min(minPath, dfs(root));
	}
	public static int dfs(TreeNode node) {
		// base case
		if (node == null) {
			return 0;
		}
		
		result += node.data;
		
		dfs(node.left);
		dfs(node.right);
		
		return result;
	}
	
	/*
	 * Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
	(Medium) - Apple
	 */
	// what is n given in?
	public static void schedule(int n) throws InterruptedException {
		long milli = n*1000;
//		Timer t = new Timer();
//		System.out.println("time: " + Calendar.MINUTE + ":" + Calendar.SECOND);
//		//t.wait(milli);
//
//		f();
		
		// IMPORTANT
		Timer t = new Timer( );
		t.scheduleAtFixedRate(new TimerTask() {
		    public void run() {
		      f();
		    }
		}, (long)milli,(long)milli);
	}
	
	public static void f() {
		System.out.println("f has been called");
		System.out.println("time: " + Calendar.HOUR_OF_DAY + ":" + Calendar.MINUTE + ":" + Calendar.SECOND);
	}
}
