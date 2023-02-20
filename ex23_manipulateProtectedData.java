package exercises;

public class ex23_manipulateProtectedData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProtectedData protectedData = new  ProtectedData();
		ManipulateProtectedData data = new ManipulateProtectedData();
		
		data.print(protectedData.str);
	}
	
	

}

class ProtectedData{
	protected String str = "Hi";
	 
}

class ManipulateProtectedData{
	void print(String protectedData) {
		System.out.println("Before manipulation, str is "+ protectedData);
		protectedData = "Hello";
		System.out.print("After manipulation, str is "+protectedData);
	}
	 
}