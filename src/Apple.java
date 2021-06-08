import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Apple {

	/*
	 * Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
	(Medium) - Apple
	 */
	public static void main(String[] args) throws InterruptedException {
		schedule(5);
	}
	
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
