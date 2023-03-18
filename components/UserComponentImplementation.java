package components;

import daoproject.dao.UserDAOImplementation;
import daoproject.dao.UserDao;
import daoproject.dto.UserDTO;

public class UserComponentImplementation implements UserComponent,Cloneable{

	private static UserComponentImplementation usercom;
	
	private UserComponentImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserComponentImplementation getUserComponentImplementationObject() {
		if(usercom==null) {
			usercom=new UserComponentImplementation();
			return usercom;
		}
		else {
			return usercom.createClone();
		}
	}
	private UserComponentImplementation createClone() {
		if(usercom!=null) {
			try{
				return (UserComponentImplementation)super.clone();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	private UserDao userdao;
	
	
	@Override
	public boolean checkUser(String uname, String upass) {
		// TODO Auto-generated method stub
		userdao = UserDAOImplementation.getUserDAOImplementationObject();
		UserDTO userDTO = userdao.findByName(uname);
		if(userDTO != null) {
			if(userDTO.getUpass().equals(upass)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkFlag(String uname) {
		// TODO Auto-generated method stub
		userdao = UserDAOImplementation.getUserDAOImplementationObject();
		UserDTO userDTO = userdao.findByName(uname);
		if(userDTO != null) {
			if(userDTO.getFlag() == 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int updateFlag(String uname, int flag) {
		// TODO Auto-generated method stub
		userdao = UserDAOImplementation.getUserDAOImplementationObject();
		UserDTO userDTO = userdao.findByName(uname);
		if(userDTO != null) {
			userDTO.setFlag(flag);
			int n = userdao.updateUser(userDTO);
			return n;
		}
		return 0;
	}

}
