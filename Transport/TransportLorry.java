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

	static LocalDateTime currentTime = LocalDateTime.now();

	static int hoursLeftlocalStartTime, minsLeftlocalStartTime, secsLeftlocalStartTime;

	static LocalDateTime resultDateTime, startDateTime;

	static LocalTime localStartTime;

	static float timeWillTakeInHrs, timeWillTakeInMins, timeWillTakeInSeconds;

	static int holidaysCount, weekNumber;

	static int year, month, day;

	static int hour, min, sec;

	static Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
	
	static Pattern TIME_PATTERN = Pattern.compile("^\\d{2}:\\d{2}:\\d{2}$");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		System.out.println("Enter the start date(YYYY-MM-DD): ");
		String startDate = s.nextLine();
		
		boolean isValidDate = DATE_PATTERN.matcher(startDate).matches();
		while (isValidDate == false) {
			System.out.println("Enter a valid start date(YYYY-MM-DD): ");
			startDate = s.nextLine();
			isValidDate = DATE_PATTERN.matcher(startDate).matches();
		}
//		String startDate = "2024-02-19";
		String dateArray[] = startDate.split("-");
		year = Integer.parseInt(dateArray[0]);
		month = Integer.parseInt(dateArray[1]);
		day = Integer.parseInt(dateArray[2]);

		System.out.println("Enter the start time(HH:MM:SS): ");
		String startTime = s.nextLine();
		boolean isValidTime = TIME_PATTERN.matcher(startTime).matches();
		while (isValidTime == false) {
			System.out.println("Enter a valid start time(HH:MM:SS): ");
			startTime = s.nextLine();
			isValidTime = TIME_PATTERN.matcher(startTime).matches();
		}
//		String startTime = "22:45:45";
		String timeArray[] = startTime.split(":");
		hour = Integer.parseInt(timeArray[0]);
		min = Integer.parseInt(timeArray[1]);
		sec = Integer.parseInt(timeArray[2]);

		System.out.println("Enter the speed(km/hr): ");
		float speed = s.nextFloat();
		System.out.println("Enter the distance(km): ");
		float distance = s.nextFloat();

//		float speed = 5;
//		float distance = 478;

		calculateEndDate(startDate, startTime, speed, distance);

	}

	static void calculateEndDate(String startDate, String startTime, float speed, float distance) {

		timeWillTakeInHrs = distance / speed;
		float addToMins = (float) Math.round((timeWillTakeInHrs - Math.floor(timeWillTakeInHrs)) * 60);

		timeWillTakeInHrs = (float) Math.floor(timeWillTakeInHrs);
		timeWillTakeInMins = addToMins;
		timeWillTakeInSeconds = 0;

		System.out.println("Initial timeWillTakeInHrs: " + timeWillTakeInHrs + " timeWillTakeInMins: "
				+ timeWillTakeInMins + " timeWillTakeInSeconds: " + timeWillTakeInSeconds);

		startDateTime = LocalDateTime.parse(startDate + "T" + startTime);
		localStartTime = LocalTime.parse(startTime);

		hoursLeftlocalStartTime = 24 - localStartTime.getHour();
		minsLeftlocalStartTime = 60 - localStartTime.getMinute();
		secsLeftlocalStartTime = 60 - localStartTime.getSecond();

		if (minsLeftlocalStartTime >= 0 && minsLeftlocalStartTime <= 60) {
			hoursLeftlocalStartTime -= 1;
		}

		if (secsLeftlocalStartTime >= 0 && secsLeftlocalStartTime <= 60) {
			minsLeftlocalStartTime -= 1;
		}

//		System.out.println("timeWillTakeInHrs: " + timeWillTakeInHrs + " timeWillTakeInMins: " + timeWillTakeInMins
//				+ " timeWillTakeInSeconds: " + timeWillTakeInSeconds);
//
//		System.out.println("hoursLeftlocalStartTime: " + hoursLeftlocalStartTime);
//		System.out.println("minsLeftlocalStartTime: " + minsLeftlocalStartTime);
//		System.out.println("secsLeftlocalStartTime: " + secsLeftlocalStartTime);

		firstDayCalculation(startDateTime);
		restDaysCalculation();


	}

	static void firstDayCalculation(LocalDateTime startDateTime) {
		if (hoursLeftlocalStartTime > DRIVE_LIMIT_HRS) {
			resultDateTime = startDateTime.plusHours((long) timeWillTakeInHrs).plusMinutes((long) timeWillTakeInMins).plusSeconds((long) timeWillTakeInSeconds);
			timeWillTakeInHrs = 0;
			timeWillTakeInMins = 0;
			timeWillTakeInSeconds = 0;	
			resultDateTime = resultDateTime.plusDays(1).withHour(0).withMinute(0).withSecond(0);
		} else if (hoursLeftlocalStartTime < DRIVE_LIMIT_HRS) {
			
			if(timeWillTakeInSeconds == 0) {
				if(timeWillTakeInMins == 0) {
					timeWillTakeInMins = 59;
					timeWillTakeInHrs -= 1;
					timeWillTakeInMins -= minsLeftlocalStartTime;
				}
				else {
					timeWillTakeInMins -= 1;
					timeWillTakeInMins -= minsLeftlocalStartTime;
				}
				timeWillTakeInSeconds = 60 - secsLeftlocalStartTime;
			}
			
			if(timeWillTakeInMins == 0) {
				timeWillTakeInHrs -= 1;
				timeWillTakeInMins = 60 - minsLeftlocalStartTime;
			}else {
				timeWillTakeInHrs -= hoursLeftlocalStartTime;
			}

			resultDateTime = startDateTime.plusHours(hoursLeftlocalStartTime).plusMinutes(minsLeftlocalStartTime)
					.plusSeconds(secsLeftlocalStartTime);
			System.out.println("After travelling on first day, current date and time: " + resultDateTime.toLocalDate()+" "+resultDateTime.toLocalTime());
		}
		System.out.println("timeWillTakeInHrs: " + timeWillTakeInHrs + " timeWillTakeInMins: " + timeWillTakeInMins
				+ " timeWillTakeInSeconds: " + timeWillTakeInSeconds);
		System.out.println("After first day calculation!!");
		System.out.println("---------------------------------------------------\n");
	}

	static void restDaysCalculation() { 
		boolean holidayResult;
		while (timeWillTakeInHrs != 0) {

			System.out.println("timeWillTakeInHrs: "+timeWillTakeInHrs+" timeWillTakeInMins: "+timeWillTakeInMins+" timeWillTakeInSeconds: "+timeWillTakeInSeconds);
			holidayResult = getIsHoliday();
			if (holidayResult == false) {
				if(timeWillTakeInHrs > DRIVE_LIMIT_HRS) {
					timeWillTakeInHrs -= DRIVE_LIMIT_HRS;
					resultDateTime = resultDateTime.plusHours(DRIVE_LIMIT_HRS);
					resultDateTime = resultDateTime.plusDays(1).withHour(0).withMinute(0).withSecond(0);
					System.out.println("(No Holiday) Current Date and time: " + resultDateTime.toLocalDate()+" "+resultDateTime.toLocalTime());
					System.out.println("-------------------------------");
					System.out.println();
				}
				else {
					resultDateTime = resultDateTime.plusHours((long) timeWillTakeInHrs).plusMinutes((long) timeWillTakeInMins).plusSeconds((long) timeWillTakeInSeconds);
					timeWillTakeInHrs = 0;
					timeWillTakeInMins = 0;
					timeWillTakeInSeconds = 0;	
				}
				
			} else {
				resultDateTime = resultDateTime.plusDays(1);
				System.out.println("(After Holiday) Current Date and time: " + resultDateTime.toLocalDate()+" "+resultDateTime.toLocalTime());
				System.out.println("-------------------------------");
				System.out.println();
			}
			
		}
		System.out.println("\n\n\nDate and time of reaching:  Before " + resultDateTime.toLocalDate() +" "+resultDateTime.toLocalTime());
		
	}

	static boolean getIsHoliday() {
		
		boolean isHoliday = false;
		
		if (resultDateTime.getMonthValue() == 1 && resultDateTime.getDayOfMonth() == 1) {
			System.out.println(resultDateTime.toLocalDate()+" Jan 1 holiday!");
			isHoliday = true;
		}

		if (resultDateTime.getMonthValue() == 1 && resultDateTime.getDayOfMonth() == 26) {
			System.out.println(resultDateTime.toLocalDate()+" Jan 26 holiday!");
			isHoliday = true;
		}

		else if (resultDateTime.getMonthValue() == 4 && resultDateTime.getDayOfMonth() == 14) {
			System.out.println(resultDateTime.toLocalDate()+" April 14 holiday!");
			isHoliday = true;
		}

		else if (resultDateTime.getMonthValue() == 5 && resultDateTime.getDayOfMonth() == 1) {
			System.out.println(resultDateTime.toLocalDate()+" May 1 holiday!");
			isHoliday = true;
		}

		else if (resultDateTime.getMonthValue() == 8 && resultDateTime.getDayOfMonth() == 15) {
			System.out.println(resultDateTime.toLocalDate()+" Aug 15 holiday!");
			isHoliday = true;
		}

		else if (resultDateTime.getMonthValue() == 9 && resultDateTime.getDayOfMonth() == 5) {
			System.out.println(resultDateTime.toLocalDate()+" September 5 holiday!");
			isHoliday = true;
		}

		else if (resultDateTime.getMonthValue() == 10 && resultDateTime.getDayOfMonth() == 2) {
			System.out.println(resultDateTime.toLocalDate()+" October 2 holiday!");
			isHoliday = true;
		}

		else if (resultDateTime.getMonthValue() == 11 && resultDateTime.getDayOfMonth() == 14) {
			System.out.println(resultDateTime.toLocalDate()+" November 14 holiday!");
			isHoliday = true;
		}

		else if (resultDateTime.getMonthValue() == 12 && resultDateTime.getDayOfMonth() == 25) {
			System.out.println(resultDateTime.toLocalDate()+" Dec 25 holiday!");
			isHoliday = true;
		}

		if (resultDateTime.getDayOfWeek().getValue() == 7) {
			System.out.println(resultDateTime.toLocalDate()+" Sunday!!");
			isHoliday = true;
		}

		Locale locale = Locale.ROOT;
		LocalDate date = LocalDate.of(resultDateTime.getYear(), resultDateTime.getMonth().getValue(), resultDateTime.getDayOfMonth());
		int weekOfMonth = date.get(WeekFields.of(locale).weekOfMonth());

		if (weekOfMonth == 2 && resultDateTime.getDayOfWeek().getValue() == 6) {
			System.out.println(resultDateTime.toLocalDate()+" Second saturday holiday!!!");
			isHoliday = true;
		}

		return isHoliday;

	}

}
