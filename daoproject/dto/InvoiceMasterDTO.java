package daoproject.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class InvoiceMasterDTO implements Comparable<UserDTO>,Serializable{

	private int invoiceNo,customerId;
	private String date;
	
	public InvoiceMasterDTO() {
		// TODO Auto-generated constructor stub
	}

	public InvoiceMasterDTO(int invoiceNo, int customerId, String date) {
		super();
		this.invoiceNo = invoiceNo;
		this.customerId = customerId;
		this.date = date;
	}

	@Override
	public String toString() {
		return "InvoiceMasterDTO [invoiceNo=" + invoiceNo + ", customerId=" + customerId + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, date, invoiceNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceMasterDTO other = (InvoiceMasterDTO) obj;
		return customerId == other.customerId && Objects.equals(date, other.date) && invoiceNo == other.invoiceNo;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public int compareTo(UserDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
