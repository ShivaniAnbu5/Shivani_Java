package app;

import action.Action;
import action.LoginAction;
import action.LogoutAction;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Action action = new LoginAction();
		
		String result = action.execute("sana", "sana234");
		
		System.out.println(result);
		
		try {
			Thread.sleep(5000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		LogoutAction action2 = new LogoutAction();
		
		result = action2.execute("sana");
		
		System.out.println(result);
	}

}
