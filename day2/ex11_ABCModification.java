package exercises;

public class ex11_ABCModification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C c = new C("Hi");
	}

}

class A{
	String a;
	public A(String text) {
		// TODO Auto-generated constructor stub
		this.a = text;
		System.out.println(a);
	}
}

class B{
	String b;
	public B(String text) {
		// TODO Auto-generated constructor stub
		this.b = text;
		System.out.println(b);
	}
}

class C extends A{

	public C(String text) {
		super(text);
		// TODO Auto-generated constructor stub
		
		
		
	}

}