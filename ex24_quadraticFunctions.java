package exercises;

public class ex24_quadraticFunctions {

	int a,b,c;
	
	public ex24_quadraticFunctions() {
		super();
		this.a = 1;
		this.b = 1;
		this.c = 1;
	}
	public ex24_quadraticFunctions(int a, int b, int c) {
		super();
		
		
	}
	
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public int getC() {
		return c;
	}
	
	void modifyParameters(int a,int b,int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	void compute(int x) {
		int result = (a*(x*x)) + (b*x) + c;
		System.out.println("Result is "+result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex24_quadraticFunctions quadraticFunctions = new ex24_quadraticFunctions();
		quadraticFunctions.compute(6);
		
//		ex24_quadraticFunctions quadraticFunctions1 = new ex24_quadraticFunctions(5,4,6);
//		quadraticFunctions1.compute(9);
		
		ex24_quadraticFunctions quadraticFunctions1 = new ex24_quadraticFunctions();
		quadraticFunctions1.modifyParameters(5, 4, 6);
		quadraticFunctions1.compute(9);
	}

}
