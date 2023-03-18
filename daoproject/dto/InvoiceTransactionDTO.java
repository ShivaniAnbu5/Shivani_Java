package daoproject.dto;

import java.io.Serializable;
import java.util.Objects;

public class InvoiceTransactionDTO implements Comparable<UserDTO>,Serializable{

	public InvoiceTransactionDTO() {
		// TODO Auto-generated constructor stub
	}
	
	private int invoiceNo,itemNo,itemQuantity;

	public InvoiceTransactionDTO(int invoiceNo, int itemNo, int itemQuantity) {
		super();
		this.invoiceNo = invoiceNo;
		this.itemNo = itemNo;
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "InvoiceTransactionDTO [invoiceNo=" + invoiceNo + ", itemNo=" + itemNo + ", itemQuantity=" + itemQuantity
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(invoiceNo, itemNo, itemQuantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceTransactionDTO other = (InvoiceTransactionDTO) obj;
		return invoiceNo == other.invoiceNo && itemNo == other.itemNo && itemQuantity == other.itemQuantity;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public int compareTo(UserDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
