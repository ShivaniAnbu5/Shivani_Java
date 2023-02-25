package exercises;

public class ex17_constMember_staticMember {
	
	public ex17_constMember_staticMember(int i) {
		
	}

	static int i = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int num = 10;
//		num = 190;
		
//		ex17_constMember_staticMember obj = new ex17_constMember_staticMember();
//		obj.nonStaticMethod();
	}
	
	void nonStaticMethod() {
		i=22;
		System.out.println(i);
	}

}
