package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EX7CountingThread {

	static int n=1;
	static String s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(()->{
			while(n<=100) {
				
				System.out.println(n);
				if(n%10 == 0) {
				s="Count: "+n;
				System.out.println(s);
				}
				n++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}

}
