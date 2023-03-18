package service;

import components.UserComponent;
import components.UserComponentImplementation;

public class LogoutServiceImplementation implements LogoutService{

	private static LogoutServiceImplementation logoutservice;
	
	private LogoutServiceImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	public static LogoutServiceImplementation getlogoutserviceImplementationObject() {
		if(logoutservice == null) {
			logoutservice = new LogoutServiceImplementation();
			return logoutservice;
		}
		else {
			return logoutservice.createClone();
		}
	}
	
	private LogoutServiceImplementation createClone() {
		if(logoutservice != null) {
			try {
				return (LogoutServiceImplementation) super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		else return null;
	}
	
	@Override
	public String logout(String uname) {
		// TODO Auto-generated method stub
		UserComponent userComponent = UserComponentImplementation.getUserComponentImplementationObject();
		int n = userComponent.updateFlag(uname, 0);
		return "Logout successfull!";
	}

}
