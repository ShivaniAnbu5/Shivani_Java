package Patterns;


//This ensures that only one instance of a class is created and provides a global access point to the object.
public class Singleton {
	public static void main(String[] args) {
		Database ts=Database.getInstance();
		ts.ID="id1";
		
		Database ts1=Database.getInstance();
		ts1.ID="id2";
		System.out.println(ts.ID+" "+ts1.ID);
	}
}

class Database{
	
	String ID;
	private static Database instance;
	
	private Database() {
		System.out.println("ts object created...");
	}
	
	synchronized public static Database getInstance() {
		if(instance!=null) {
			return instance;
		}
		else {
			instance=new Database();
			return instance;
		}	
		
		
	}

	
}