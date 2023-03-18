package daoproject.dao;

import java.util.Collection;

import daoproject.dto.ItemMasterDTO;

public abstract class ItemMasterDao {

	public abstract ItemMasterDTO findByItemNo(int itemNo);
	public abstract ItemMasterDTO findByItemDescription(String itemDescription);
	public abstract int deleteByItemNo(int itemNo);
	public abstract String getItemDescriptionByItemNo(int itemNo);
	public abstract Collection<ItemMasterDTO> findAllItems();
	public abstract int updateItem(ItemMasterDTO itemMasterDto);
	public abstract int getPriceByItemNo(int itemNo);
	public abstract int getPriceByItemNoAndQuantity(int itemNo,int itemQuantity);
}
