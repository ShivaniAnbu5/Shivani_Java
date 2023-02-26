package Multithreading;

public class Ex5ThreadStart implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new Ex5ThreadStart());
		
		//When the thread is started,it will call the run method of this class's instance instead of its own run method
		thread.start();
		//After started,it will go to the thread pool where it waits to be executed..after that..its destroyed and therefore the system does not know about it
		
		//IllegalThreadStateException
//		thread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread "+Thread.currentThread().getName() +" started and is running!!!");
		
		
	}
	 

}
