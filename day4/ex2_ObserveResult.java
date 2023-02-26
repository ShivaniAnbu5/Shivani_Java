package exercises;

public class ex2_ObserveResult {
	public void mth1(){
		mth2();
		System.out.println("caller");
	}
	
	public void mth2() {
		try {
			int num = 1/0;
			return;
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
		ex2_ObserveResult obj = new ex2_ObserveResult();
		obj.mth1();
	}

}
