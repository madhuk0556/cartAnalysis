/**
 * 
 */
package com.tek.interview.util;

/**
 * @author H156759
 *
 */
public class ApplicationUtil {

	/**
	 * @param value
	 * @param places
	 * @return
	 */
	public static double rounding(double value, int places) {
		 if (places < 0) throw new IllegalArgumentException();

		    long factor = (long) Math.pow(10, places);
		    value = value * factor;
		    long tmp = Math.round(value);
		    return (double) tmp / factor;
	}
}
