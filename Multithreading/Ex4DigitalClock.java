package Multithreading;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex4DigitalClock {
	static int n =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Clock clock = new Clock();
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(()->{
			Thread.currentThread().setName("thread 1");
			while(n<10) {
				n++;
			clock.displayTime();
			}
		});
		
		es.execute(()->{
			Thread.currentThread().setName("thread 2");
			while(n<10) {
				n++;
			clock.displayTime();
			}
		});
		
	}

}

class Clock{
	String strTime;
	  synchronized void displayTime() {
		try {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
				Date date = cal.getTime();
				strTime = formatter.format(date);
				System.out.println(Thread.currentThread().getName()+" "+strTime);
				Thread.sleep(1000);
			
		}
		catch(Exception e) {
			System.out.println("exception ");
		}
	}
}