package action;

import service.LogoutServiceImplementation;

public class LogoutAction{

	public String execute(String uname) {
		// TODO Auto-generated method stub
		LogoutServiceImplementation logoutServiceImplementation = LogoutServiceImplementation.getlogoutserviceImplementationObject();
		String result = logoutServiceImplementation.logout(uname);
		return result;
	}

}
