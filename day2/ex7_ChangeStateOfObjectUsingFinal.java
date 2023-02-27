package exercises;

public class ex7_ChangeStateOfObjectUsingFinal {

	int a = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ex7_ChangeStateOfObjectUsingFinal obj = new ex7_ChangeStateOfObjectUsingFinal();
		System.out.println(obj.a);
		obj.a=9;
		System.out.println(obj.a);
	}
}


