package Multithreading;

public class Ex8 extends Thread{
	
	static StringBuffer buffer;
	
	public Ex8(StringBuffer stringBuffer) {
		// TODO Auto-generated constructor stub
		buffer = stringBuffer;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buffer = new StringBuffer("A");
		Ex8 obj1 = new Ex8(buffer);
		Ex8 obj2 = new Ex8(buffer);
		Ex8 obj3 = new Ex8(buffer);

		obj1.start();
		obj2.start();
		obj3.start();
		
		}

	@Override
	synchronized public void run() {
		// TODO Auto-generated method stub
		super.run();
		synchronized(buffer) {
		int i=0;
		while(i<100) {
		System.out.println(buffer);
		i++;
		}
		buffer.setCharAt(0, (char)(buffer.charAt(0) + 1));
		}
	}
  
}
