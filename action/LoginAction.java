package action;

import service.LoginService;
import service.LoginServiceImplementation;

public class LoginAction extends Action{

	@Override
	public String execute(String uname, String upass) {
		// TODO Auto-generated method stub
		LoginService loginService = LoginServiceImplementation.getLoginServiceImplementationObject();
		
		String loginResult = loginService.login(uname, upass);
		return loginResult;
	}

}
