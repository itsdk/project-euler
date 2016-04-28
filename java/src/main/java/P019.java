package main.java;

/*
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, 
 * but not on a century unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

public class P019 extends Problem {

	@Override
	public String solve() {
		int sundayMonths = 0; // number to return; number of months that start with Sunday
		
		/*
		 * leap year if year is divisible by 4,
		 * but not on a century unless century is divisible by 400
		 */
		boolean leapYear = false; 
		
		int dayOfWeek = 1;    // 1-7, the day of the week
		
		/*
		 * 1 Jan 1900 is Monday (dayOfWeek = 1),
		 * but we want to start on 1 Jan 1901, which is 
		 * one (non-leap year) year later:
		 */
		dayOfWeek += 365%7;
		
		for (int y=1901; y<=2000; y++) { // years given in problem
			
			if (y%100 == 0) { // on a century
				leapYear = (y%400 == 0) ? true : false;
			} else {
				leapYear = (y%4 == 0) ? true : false;
			}
			
			int days = 0; // number of days in the month
			for (int m=1; m<=12; m++) { // months of the year
				
				if (dayOfWeek == 7) { // SUNDAY!!!
					sundayMonths++;
				}
				
				switch (m) { // calculate number of days per month
					case 2: days = (leapYear) ? 29 : 28; break;
					case 4: case 6: case 9: case 11: days = 30; break;
					default: days = 31; break;
				}
				
				for (int d=1; d<=days; d++) { // days of month
					dayOfWeek++;
					if (dayOfWeek > 7) { dayOfWeek = 1; }
				}
				
			}
		}
		
		return Integer.toString(sundayMonths);
	}

}
