package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex2DisplayDifferentMsg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2DisplayDifferentMsg obj = new Ex2DisplayDifferentMsg();
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		es.execute(() -> {
			obj.printMsg("Message 1");
		});
		
		es.execute(() -> {
			obj.printMsg("Message 2");
		});
		
		es.execute(() -> {
			obj.printMsg("Message 3");
		});
	}
	
	 synchronized void printMsg(String text) {
		System.out.print("[------");
		System.out.print(text);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("------]");
	}

}
