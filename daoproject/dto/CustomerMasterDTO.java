package daoproject.dto;

import java.io.Serializable;
import java.util.Objects;

public class CustomerMasterDTO implements Comparable<UserDTO>,Serializable{

	private int customerId;
	private String customerName,customerAddress;
	
	public CustomerMasterDTO() {
		// TODO Auto-generated constructor stub
	}

	public CustomerMasterDTO(int customerId, String customerName, String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "CustomerMasterDTO [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerAddress, customerId, customerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerMasterDTO other = (CustomerMasterDTO) obj;
		return Objects.equals(customerAddress, other.customerAddress) && customerId == other.customerId
				&& Objects.equals(customerName, other.customerName);
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public int compareTo(UserDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
