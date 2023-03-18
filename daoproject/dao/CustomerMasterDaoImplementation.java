package daoproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import daoproject.dto.CustomerMasterDTO;
import dbConnection.DBUtility;

public class CustomerMasterDaoImplementation extends CustomerMasterDao{

private static CustomerMasterDaoImplementation customerMaster;
	
	private CustomerMasterDaoImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	public static CustomerMasterDaoImplementation CustomerMasterDaoImplementationObject() {
		if(customerMaster == null) {
			customerMaster = new CustomerMasterDaoImplementation();
			return customerMaster;
		}
		else {
			return customerMaster.createClone();
		}
	}
	
	private CustomerMasterDaoImplementation createClone() {
		if(customerMaster!=null) {
			try {
				return (CustomerMasterDaoImplementation)super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		else return null;
	}
	
	
	@Override
	public CustomerMasterDTO findByCustomerId(int custId) {
		// TODO Auto-generated method stub
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from customermaster where custid=?");
			ps.setInt(1, custId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				CustomerMasterDTO customerDto=new CustomerMasterDTO();
				customerDto.setCustomerId(rs.getInt("custid"));
				customerDto.setCustomerName(rs.getString("custname"));
				customerDto.setCustomerAddress(rs.getString("custaddress"));
				return customerDto;
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
	public CustomerMasterDTO findByCustomerName(String custName) {
		// TODO Auto-generated method stub
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from customermaster where custname=?");
			ps.setString(1, custName);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				CustomerMasterDTO customerDto=new CustomerMasterDTO();
				customerDto.setCustomerId(rs.getInt("custid"));
				customerDto.setCustomerName(rs.getString("custname"));
				customerDto.setCustomerAddress(rs.getString("custaddress"));
				return customerDto;
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
	public CustomerMasterDTO findByCustomerAddress(String custAddress) {
		// TODO Auto-generated method stub
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from customermaster where custaddress=?");
			ps.setString(1, custAddress);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				CustomerMasterDTO customerDto=new CustomerMasterDTO();
				customerDto.setCustomerId(rs.getInt("custid"));
				customerDto.setCustomerName(rs.getString("custname"));
				customerDto.setCustomerAddress(rs.getString("custaddress"));
				return customerDto;
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
	public Collection<CustomerMasterDTO> findAllCustomers() {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from customermaster");
			List<CustomerMasterDTO> customers = new ArrayList<>();
			while(rs.next()) {
				CustomerMasterDTO customerDto=new CustomerMasterDTO();
				customerDto.setCustomerId(rs.getInt("custid"));
				customerDto.setCustomerName(rs.getString("custname"));
				customerDto.setCustomerAddress(rs.getString("custaddress"));
				customers.add(customerDto);
			}
			return customers;

		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int updateCustomer(CustomerMasterDTO customerMasterDto) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			int custId = customerMasterDto.getCustomerId();
			PreparedStatement ps = con.prepareStatement("select * from customermaster where custid=?");
			ps.setInt(1, custId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ps = con.prepareStatement("update customermaster set custname=?,custaddress=? where custid=?");
				ps.setString(1, customerMasterDto.getCustomerName());
				ps.setString(2, customerMasterDto.getCustomerAddress());
				ps.setInt(3, custId);
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
	public int deleteCustomerById(int custId) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from customermaster where custid=?");
			ps.setInt(1, custId);
			int n = ps.executeUpdate();
			DBUtility.closeConnection(null);
			return n;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}
	
	@Override
	public int deleteCustomerByName(String custName) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from customermaster where custname=?");
			ps.setString(1, custName);
			int n = ps.executeUpdate();
			DBUtility.closeConnection(null);
			return n;
		}catch(Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}
	
	public static void main(String[] args) {
		CustomerMasterDao customerMasterDao = new CustomerMasterDaoImplementation();
		
		System.out.println(customerMasterDao.findByCustomerId(1));
		System.out.println(customerMasterDao.findByCustomerName("shiva"));
		System.out.println(customerMasterDao.findByCustomerAddress("ambattur"));
		System.out.println(customerMasterDao.findAllCustomers());
		
		CustomerMasterDTO customerMasterDTO = new CustomerMasterDTO();
		customerMasterDTO.setCustomerId(3);
		customerMasterDTO.setCustomerName("pranav");
		customerMasterDTO.setCustomerAddress("annanagar");
		System.out.println(customerMasterDao.updateCustomer(customerMasterDTO));
	}

	

	

}
