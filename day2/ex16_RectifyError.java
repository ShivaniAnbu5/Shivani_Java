package exercises;

public class ex16_RectifyError {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		X x1 = new X();
		X x2 = new Y();
		Y y1 = new Y();
//		(Y) X2.do2();
		//Cast it to Y
		((Y)x2).do2();
	}

}

class X{
	void do1() {
		
	}
}

class Y extends X{
	void do2() {
		
	}
}