package exercises;

public class ex5_CalculateNumOfObjectsCreated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectA a = new ObjectA();
		ObjectA a1 = new ObjectA();
		ObjectA a2 = new ObjectA();
		ObjectA a3 = new ObjectA();
		ObjectA a4 = new ObjectA();
		

	}

}

class ObjectA{
	static int objectCount = 0;
	public ObjectA() {
		objectCount++;
		System.out.println("Object count:"+objectCount);
	}

}