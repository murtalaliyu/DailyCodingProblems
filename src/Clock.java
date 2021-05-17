/*
 * Given a clock time in hh:mm format, determine, to the nearest degree, 
 * the angle between the hour and the minute hands.
Bonus: When, during the course of a day, will the angle be zero? (easy) - Microsoft
 */
public class Clock {
	public static void main(String[] args) {
		System.out.println(clock(3,30));
	}
	
	/*
	 * based on a 12-hour clock
	 */
	public static int clock(int hh, int mm) {
		int hr = (hh * 360)/12  + (mm * 360)/(12*60); //<- 3pm  90
		int min = (mm*360)/60;	// <- 0
		int angle = Math.abs(hr-min);
		System.out.println("internal angle: " + angle);
		if (angle > 180) {
			angle = 360 - angle;
		}
		return angle;
	}
}
