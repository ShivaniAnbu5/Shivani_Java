package exercises;

public class ex13_AbstractClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Instance can't be created for abstract class
		AbstractClass absClass = new AbstractClass();
	}

}

abstract class AbsractClass{
	void methodA() {
		System.out.println("This is method A");
	}
	void methodB() {
		System.out.println("This is method B");
	}
}
