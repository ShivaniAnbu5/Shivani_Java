package exercises;

public class ex10_ClassABC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C c = new C();
		//C's default constructor will be called.SInce it extend A,super class's constructor is also called
	}

}

class A{
	public A() {
		// TODO Auto-generated constructor stub
		System.out.println("Class A constructor called");
	}
}

class B{
	public B() {
		// TODO Auto-generated constructor stub
		System.out.println("Class B constructor called");
	}
}

class C extends A{
	B b;
}