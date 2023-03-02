package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex3InventorySystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventory inventory = new Inventory();

		ExecutorService es = Executors.newFixedThreadPool(2);

		es.execute(() -> {
			Thread.currentThread().setName("Producer");
			for (int i = 0; i < 5; i++) {
				inventory.produce();
			}
		});

		es.execute(() -> {
			Thread.currentThread().setName("Consumer");
			for (int i = 0; i < 5; i++) {
				inventory.consume();
			}
		});

		es.shutdown();
	}
}

class Inventory {
	boolean productPresent = false;

	synchronized void produce() {
		if (productPresent) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		System.out.println("Added one product...");
		productPresent = true;
		notify();
	}

	synchronized void consume() {
		if (!productPresent) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		System.out.println("Consumed one product...");
		productPresent = false;
		notify();
	}

}
