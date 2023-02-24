package exercises;

public class ex3_Replace2ndEx {

	public void mth1(){
		mth2();
		System.out.println("caller");
	}
	
	public void mth2() {
		try {
			System.exit(0);
			
		}
		catch(Exception e) {
			System.out.println("catch-mth2");
		}
		finally {
			System.out.println("finally-mth2");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex3_Replace2ndEx obj = new ex3_Replace2ndEx();
		obj.mth1();
	}

}
