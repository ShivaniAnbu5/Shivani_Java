package daoproject.dao;

import java.util.Collection;

import daoproject.dto.CustomerMasterDTO;

public abstract class CustomerMasterDao {

	public abstract CustomerMasterDTO findByCustomerId(int custId);
	public abstract CustomerMasterDTO findByCustomerName(String custName);
	public abstract CustomerMasterDTO findByCustomerAddress(String custAddress);
	public abstract Collection<CustomerMasterDTO> findAllCustomers();
	public abstract int updateCustomer(CustomerMasterDTO customerMasterDto);
	public abstract int deleteCustomerById(int custId);
	public abstract int deleteCustomerByName(String custName);
}
