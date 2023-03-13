package Transport;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.WeekFields;

public class TransportLorry {

	static final int DRIVE_LIMIT_HRS = 8;
	static int hoursLeftOnFirstDay, minsLeftOnFirstDay, secsLeftOnFirstDay;
	static LocalDateTime resultDateTime, startDateTime;
	static float remainingTimeInHrs, remainingTimeInMins, remainingTimeInSeconds = 0;
	static Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
	static Pattern TIME_PATTERN = Pattern.compile("^\\d{2}:\\d{2}:\\d{2}$");
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter the start date(YYYY-MM-DD): ");
		String startDate = scanner.nextLine();
		startDate = isValidDateOrTime(startDate, DATE_PATTERN);
		
		System.out.println("Enter the start time(HH:MM): ");
		String startTime = scanner.nextLine();
		startTime += ":00";
		startTime = isValidDateOrTime(startTime, TIME_PATTERN);
		
		System.out.println("Enter the speed(km/hr): ");
		float speed = scanner.nextFloat();
		
		System.out.println("Enter the distance(km): ");
		float distance = scanner.nextFloat();

		calculateEndDate(startDate, startTime, speed, distance);

		scanner.close();
		
	}
	
	static String isValidDateOrTime(String value, Pattern pattern) {
		boolean isValid = pattern.matcher(value).matches();
		while (isValid == false) {
			System.out.println("Invalid! Enter again: ");
			value = scanner.nextLine();
			isValid = pattern.matcher(value).matches();
		}
		return value;
	}

	static void calculateEndDate(String startDate, String startTime, float speed, float distance) {

		//Remaining time to travel - calculation
		remainingTimeInHrs = distance / speed;
		remainingTimeInMins = (float) Math.round((remainingTimeInHrs - Math.floor(remainingTimeInHrs)) * 60);
		remainingTimeInHrs = (float) Math.floor(remainingTimeInHrs);
		System.out.println("Initial remaining hrs: " + remainingTimeInHrs + ", remaining mins: "+ remainingTimeInMins + ", remaining seconds: " + remainingTimeInSeconds);
		startDateTime = LocalDateTime.parse(startDate + "T" + startTime);
		LocalTime localStartTime = LocalTime.parse(startTime);
		hoursLeftOnFirstDay = 24 - localStartTime.getHour();
		minsLeftOnFirstDay = 60 - localStartTime.getMinute();
		if (minsLeftOnFirstDay > 0 && minsLeftOnFirstDay <= 60) {
			hoursLeftOnFirstDay -= 1;
		}
		System.out.println("StartTime hours-left:" + hoursLeftOnFirstDay+", mins-left: " + minsLeftOnFirstDay+", secs-left: " + secsLeftOnFirstDay+"\n");

		//First day calculation
		if (hoursLeftOnFirstDay > DRIVE_LIMIT_HRS) {
			if((remainingTimeInHrs == DRIVE_LIMIT_HRS && remainingTimeInMins == 0) || remainingTimeInHrs < DRIVE_LIMIT_HRS) {
				resultDateTime = startDateTime.plusDays(0).withHour((int)(localStartTime.getHour() + remainingTimeInHrs)).withMinute((int)(localStartTime.getMinute() + remainingTimeInMins));
				System.out.print("Date and time of reaching: " + resultDateTime.toLocalDate()+ " " + resultDateTime.toLocalTime());
				resultDateTime = startDateTime.plusDays(1).withHour(0).withMinute(0).withSecond(0);
				System.out.print(" or before " + resultDateTime.toLocalDate()+ " " + resultDateTime.toLocalTime());
				return;
			}
			else {
				remainingTimeInHrs -= DRIVE_LIMIT_HRS;
			}		
		} 
		else {
			remainingTimeInHrs -= hoursLeftOnFirstDay;
			remainingTimeInMins -= minsLeftOnFirstDay;
		}
		resultDateTime = startDateTime.plusDays(1).withHour(0).withMinute(0).withSecond(0);
		System.out.println("After travelling on first day, \nCurrent date and time: " + resultDateTime.toLocalDate()+ " " + resultDateTime.toLocalTime());
		
		//Remaining days calculation
		boolean isHoliday;
		while (remainingTimeInHrs != 0) {
			System.out.println("Remaining hrs: " + remainingTimeInHrs + ", remaining mins: "+ remainingTimeInMins + ", remaining seconds: " + remainingTimeInSeconds +'\n');
			isHoliday = getIsHoliday();
			if (isHoliday == false) {
				if (remainingTimeInHrs > DRIVE_LIMIT_HRS) {
					remainingTimeInHrs -= DRIVE_LIMIT_HRS;
					resultDateTime = resultDateTime.plusDays(1).withHour(0).withMinute(0).withSecond(0);
				} else {
					resultDateTime = resultDateTime.plusHours((long) remainingTimeInHrs).plusMinutes((long) remainingTimeInMins).plusSeconds((long) remainingTimeInSeconds);
					remainingTimeInHrs = 0;
				}
			}
			else {
				resultDateTime = resultDateTime.plusDays(1);	
			}
			System.out.println("Current Date and time: " + resultDateTime.toLocalDate() + " " + resultDateTime.toLocalTime());	
		}
		
		//Final reaching date and time
		System.out.print("Date and time of reaching: " + resultDateTime.toLocalDate()+ " " + resultDateTime.toLocalTime());
		resultDateTime = resultDateTime.plusDays(1).withHour(0).withMinute(0).withSecond(0);
		System.out.print(" or before " + resultDateTime.toLocalDate()+ " " + resultDateTime.toLocalTime());

	}

	static boolean getIsHoliday() {
		
		int year = resultDateTime.getYear();
		int month = resultDateTime.getMonthValue();
		int day = resultDateTime.getDayOfMonth();
		int dayOfWeek = resultDateTime.getDayOfWeek().getValue();

		boolean isHoliday = false;

		if ((month == 1 && (day == 1 || day == 26)) || (month == 4 && day == 14) || (month == 5 && day == 1) || (month == 8 && day == 15) || (month == 9 && day == 5) || (month == 10 && day == 2) || (month == 11 && day == 14) || (month == 12 && day == 25) ) {		
			System.out.println(resultDateTime.toLocalDate() + " Holiday!");
			isHoliday = true;
		}

		if (dayOfWeek == 7) {
			System.out.println(resultDateTime.toLocalDate() + " Sunday holiday!");
			isHoliday = true;
		}

		Locale locale = Locale.ROOT;
		LocalDate date = LocalDate.of(year,month,day);
		int weekOfMonth = date.get(WeekFields.of(locale).weekOfMonth());
		if (weekOfMonth == 2 && dayOfWeek == 6) {
			System.out.println(resultDateTime.toLocalDate() + " Second saturday holiday!");
			isHoliday = true;
		}

		return isHoliday;

	}
}
