package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex1OddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1OddEven obj = new Ex1OddEven();
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		es.execute(() -> {
			synchronized(obj) {
			obj.printOddNumbers();
			}
		});
		
		es.execute(() -> {
			synchronized(obj) {
			obj.printEvenNumbers();
			}
		});
	}
	
	void printOddNumbers() {
		System.out.println("Odd numbers");
		for(int i=1;i<100;i++)
		{
			if(i%2 != 0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		
	}
	
	void printEvenNumbers() {
		System.out.println("Even numbers");
		for(int i=1;i<100;i++)
		{
			if(i%2 == 0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}

}
