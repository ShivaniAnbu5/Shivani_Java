package exercises;

public class ex3_AllTypesOfInitializationAndTypeCasting {
	
	static int integer1;
	static int integer2;
	
	static {
		integer1=200;
		System.out.println(integer1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int integer = 5;
		 short shortInt = 5;
		 long longInt = 214324536;
		 boolean bool = false;
		 float floatNum = 0.56f;
		 double doubleNum = 3.6575675685;
		 char character = 'a';
		 
		 System.out.print("Before type casting, "+doubleNum);
		 doubleNum = floatNum;
		 System.out.print("\nAfter type casting, "+doubleNum);
		 
		 System.out.print("\nBefore type casting, "+integer);
		 integer = (int) longInt;
		 System.out.print("\nAfter type casting, "+integer);
	}

}
