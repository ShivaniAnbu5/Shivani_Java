package exercises;

public class ex8_SingletonClass {

	static ex8_SingletonClass singleInstance;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ex8_SingletonClass obj1 = new ex8_SingletonClass();
		ex8_SingletonClass ob1 = obj1.getInstance();
		
		ex8_SingletonClass obj2 = new ex8_SingletonClass();
		ex8_SingletonClass ob2 = obj2.getInstance();
		
		ex8_SingletonClass obj3 = new ex8_SingletonClass();
		ex8_SingletonClass ob3 = obj3.getInstance();
		
		ex8_SingletonClass obj4 = new ex8_SingletonClass();
		ex8_SingletonClass ob4 = obj4.getInstance();
		
		System.out.println(ob1.hashCode()+"\n"+ob2.hashCode()+"\n"+ob3.hashCode()+"\n"+ob4.hashCode()+"\n");
		if(ob1 == ob2 && ob2==ob3 && ob3==ob4) {
			System.out.println("All objects point to the same location");
		}
		else {
			System.out.println("Objects don't point to the same location");
		}
	}
	
	public ex8_SingletonClass getInstance() {
		if(singleInstance == null) singleInstance  = new ex8_SingletonClass();
		return singleInstance;
		
	}
}
