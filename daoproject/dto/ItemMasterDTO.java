package daoproject.dto;

import java.io.Serializable;
import java.util.Objects;

public class ItemMasterDTO implements Comparable<UserDTO>,Serializable{

	private int itemNo,itemUnit;
	private String itemDescription;
	private double itemPrice;
	
	public ItemMasterDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemMasterDTO(int itemNo, int itemUnit, String itemDescription, double itemPrice) {
		super();
		this.itemNo = itemNo;
		this.itemUnit = itemUnit;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
	}



	@Override
	public String toString() {
		return "ItemMasterDTO [itemNo=" + itemNo + ", itemUnit=" + itemUnit + ", itemDescription=" + itemDescription
				+ ", itemPrice=" + itemPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemDescription, itemNo, itemPrice, itemUnit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemMasterDTO other = (ItemMasterDTO) obj;
		return Objects.equals(itemDescription, other.itemDescription) && itemNo == other.itemNo
				&& Double.doubleToLongBits(itemPrice) == Double.doubleToLongBits(other.itemPrice)
				&& itemUnit == other.itemUnit;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(int itemUnit) {
		this.itemUnit = itemUnit;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public int compareTo(UserDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
