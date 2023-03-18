package service;

import components.UserComponent;
import components.UserComponentImplementation;

public class LoginServiceImplementation implements LoginService{

	private static LoginServiceImplementation loginservice;
	
	private LoginServiceImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	public static LoginServiceImplementation getLoginServiceImplementationObject() {
		if(loginservice == null) {
			loginservice = new LoginServiceImplementation();
			return loginservice;
		}
		else {
			return loginservice.createClone();
		}
	}
	
	private LoginServiceImplementation createClone() {
		if(loginservice != null) {
			try {
				return (LoginServiceImplementation) super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		else return null;
	}
	
	@Override
	public String login(String uname, String upass) {
		// TODO Auto-generated method stub
		UserComponent userComponent = UserComponentImplementation.getUserComponentImplementationObject();
		if(userComponent.checkUser(uname, upass)) {
			if(userComponent.checkFlag(uname)) {
				userComponent.updateFlag(uname, 1);
				return "Welcome!";
			}
			else {
				return "Already logged in!";
			}
		}
		else {
			return "Sign up";
		}
	}

}
