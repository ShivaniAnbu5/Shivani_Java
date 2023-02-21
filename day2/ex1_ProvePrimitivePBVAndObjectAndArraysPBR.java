package exercises;

public class ex1_ProvePrimitivePBVAndObjectAndArraysPBR {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = 5;
		subclass obj = new subclass();
		
		obj.printPBV(value);
		System.out.println("After whole PBV execution value is "+value);
		
		obj.printPBR(obj);
		System.out.println("After whole PBR execution value is "+obj.referenceValue);
		
	}
	
	void printPBV(int val) {
		System.out.println("Before PBV, value is "+val);
	}
	
	void printPBR(subclass obj) {
		System.out.println("Before PBR, value is "+ obj.referenceValue);
	}

}

class subclass extends ex1_ProvePrimitivePBVAndObjectAndArraysPBR{

	int referenceValue = 100;

	@Override
	void printPBV(int val) {
		// TODO Auto-generated method stub
		super.printPBV(val);
		referenceValue = 100;
		System.out.println("After PBV execution value is "+referenceValue);
	}

	@Override
	void printPBR(subclass obj) {
		// TODO Auto-generated method stub
		super.printPBR(obj);
		obj.referenceValue = 6587;
		System.out.println("After PBR execution value is "+obj.referenceValue);
	}

	
	
	
	
	
}