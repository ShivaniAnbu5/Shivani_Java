package Patterns;

public class Singleton {
	public static void main(String[] args) {
		Database ts=Database.createSingleTon();
		ts.ID="df";
		
		Database ts1=Database.createSingleTon();
		ts1.ID="ffdf";
		System.out.println(ts.ID+" "+ts1.ID);
	}
}

class Database{
	
	String ID;
	private static Database instance;
	
	private Database() {
		System.out.println("ts object created...");
	}
	
	synchronized public static Database createSingleTon() {
		if(instance!=null) {
			return instance;
		}
		else {
			instance=new Database();
			return instance;
		}	
		
		
	}

	
}