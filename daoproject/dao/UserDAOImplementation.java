package daoproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import daoproject.dto.UserDTO;
import dbConnection.DBUtility;

public class UserDAOImplementation extends UserDao implements Cloneable{

	private static UserDAOImplementation userDao;
	
	private UserDAOImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserDAOImplementation getUserDAOImplementationObject() {
		if(userDao == null) {
			userDao = new UserDAOImplementation();
			return userDao;
		}
		else {
			return userDao.createClone();
		}
	}
	
	private UserDAOImplementation createClone() {
		if(userDao!=null) {
			try {
				return (UserDAOImplementation)super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		else return null;
	}
	@Override
	public UserDTO findByID(int uid) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users where uid=?");
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				UserDTO userdto = new UserDTO();
				userdto.setUid(uid);
				userdto.setUname(rs.getString("uname"));
				userdto.setUpass(rs.getString("upass"));
				userdto.setFlag(rs.getInt("flag"));
				userdto.setAge(rs.getInt("age"));
				return userdto;
			}
			else {
				return null;
			}
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
		
	}

	@Override
	public UserDTO findByName(String uname) {
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users where uname=?");
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				UserDTO userdto = new UserDTO();
				userdto.setUid(rs.getInt("uid"));
				userdto.setUname(rs.getString("uname"));
				userdto.setUpass(rs.getString("upass"));
				userdto.setFlag(rs.getInt("flag"));
				userdto.setAge(rs.getInt("age"));
				return userdto;
			}
			else {
				return null;
			}
		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public Collection<UserDTO> findAll() {
		try {
			Connection con = DBUtility.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from users");
			List<UserDTO> users = new ArrayList<>();
			while(rs.next()) {
				UserDTO userdto = new UserDTO();
				userdto.setUid(rs.getInt("uid"));
				userdto.setUname(rs.getString("uname"));
				userdto.setUpass(rs.getString("upass"));
				userdto.setFlag(rs.getInt("flag"));
				userdto.setAge(rs.getInt("age"));
				users.add(userdto);
			}
			return users;

		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int updateUser(UserDTO userdto) {
		try {
			Connection con = DBUtility.getConnection();
			int userid = userdto.getUid();
			PreparedStatement ps = con.prepareStatement("select * from users where uid=?");
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ps = con.prepareStatement("update users set uname=?,upass=?,age=?,flag=? where uid=?");
				ps.setString(1, userdto.getUname());
				ps.setString(2, userdto.getUpass());
				ps.setInt(3, userdto.getAge());
				ps.setInt(4, userdto.getFlag());
				ps.setInt(5, userdto.getUid());
				int n = ps.executeUpdate();
				//If there's no exception,then commit  the changes
				DBUtility.closeConnection(null);
				return n;
			}
			else {
				return 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
			
			//If there's an exception, it will be rolled back to the previous state
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public int deleteUserByID(int uid) {
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from users where uid=?");
			ps.setInt(1, uid);
			int n = ps.executeUpdate();
			DBUtility.closeConnection(null);
			return n;
		}catch(Exception e) {
			e.printStackTrace();
			
			//If there's an exception, it will be rolled back to the previous state
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public int deleteUserByName(String uname) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from users where uname=?");
			ps.setString(1, uname);
			int n = ps.executeUpdate();
			DBUtility.closeConnection(null);
			return n;
		}catch(Exception e) {
			e.printStackTrace();
			
			//If there's an exception, it will be rolled back to the previous state
			DBUtility.closeConnection(e);
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
		UserDao users = new UserDAOImplementation();

//		System.out.println(users.findByID(4));
//      System.out.println( users.deleteUserByID(2));	
//      System.out.println( users.deleteUserByName("ashi"));
//		UserDTO userDTO = users.findByID(3);
//		users.updateUser(userDTO);
		//users.deleteUserByID(2);
//		System.out.println(users.deleteUserByID(3));
		
	}

}
