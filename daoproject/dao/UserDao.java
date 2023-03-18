package daoproject.dao;

import java.util.Collection;

import daoproject.dto.UserDTO;

public abstract class UserDao {
	
	public abstract UserDTO findByID(int uid);
	public abstract UserDTO findByName(String uname);
	public abstract Collection<UserDTO> findAll();
	public abstract int updateUser(UserDTO userdto);
	public abstract int deleteUserByID(int uid);
	public abstract int deleteUserByName(String uname);

}

