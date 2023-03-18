package daoproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import daoproject.dto.ItemMasterDTO;
import dbConnection.DBUtility;

public class ItemMasterDaoImplementation extends ItemMasterDao{

	private static ItemMasterDaoImplementation itemMaster;
	
	private ItemMasterDaoImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	public static ItemMasterDaoImplementation ItemMasterDaoImplementationObject() {
		if(itemMaster == null) {
			itemMaster = new ItemMasterDaoImplementation();
			return itemMaster;
		}
		else {
			return itemMaster.createClone();
		}
	}
	
	private ItemMasterDaoImplementation createClone() {
		if(itemMaster!=null) {
			try {
				return (ItemMasterDaoImplementation)super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		else return null;
	}
	
	@Override
	public ItemMasterDTO findByItemNo(int itemNo) {
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from items where itemno=?");
			ps.setInt(1, itemNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ItemMasterDTO itemDto=new ItemMasterDTO();
				itemDto.setItemDescription(rs.getString("itemdesc"));
				itemDto.setItemPrice(rs.getInt("itemprice"));
				itemDto.setItemUnit(rs.getInt("itemunit"));
				itemDto.setItemNo(itemNo);
				return itemDto;
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
	public ItemMasterDTO findByItemDescription(String itemDescription) {
		// TODO Auto-generated method stub
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from items where itemdesc=?");
			ps.setString(1, itemDescription);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ItemMasterDTO itemDto=new ItemMasterDTO();
				itemDto.setItemDescription(rs.getString("itemdesc"));
				itemDto.setItemPrice(rs.getInt("itemprice"));
				itemDto.setItemUnit(rs.getInt("itemunit"));
				itemDto.setItemNo(rs.getInt("itemno"));
				return itemDto;
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
	public String getItemDescriptionByItemNo(int itemNo) {
		// TODO Auto-generated method stub
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select itemdesc from items where itemno=?");
			ps.setInt(1, itemNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String itemDesc = rs.getString("itemdesc");
				return itemDesc;
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
	public Collection<ItemMasterDTO> findAllItems() {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from items");
			List<ItemMasterDTO> items = new ArrayList<>();
			while(rs.next()) {
				ItemMasterDTO itemDto=new ItemMasterDTO();
				itemDto.setItemNo(rs.getInt("itemno"));
				itemDto.setItemDescription(rs.getString("itemdesc"));
				itemDto.setItemPrice(rs.getInt("itemprice"));
				itemDto.setItemUnit(rs.getInt("itemunit"));
				items.add(itemDto);
			}
			return items;

		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int getPriceByItemNo(int itemNo) {
		// TODO Auto-generated method stub
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select itemprice from items where itemno=?");
			ps.setInt(1, itemNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int itemPrice = rs.getInt("itemprice");
				return itemPrice;
			}
			else {
				return 0;
			}
			}catch(Exception e) {
				DBUtility.closeConnection(e);
				return 0;
			}
	}

	@Override
	public int getPriceByItemNoAndQuantity(int itemNo, int itemQuantity) {
		// TODO Auto-generated method stub
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select itemprice from items where itemno=?");
			ps.setInt(1, itemNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int itemPrice = rs.getInt("itemprice");
				return itemPrice * itemQuantity;
			}
			else {
				return 0;
			}
			}catch(Exception e) {
				DBUtility.closeConnection(e);
				return 0;
			}
	}

	@Override
	public int updateItem(ItemMasterDTO itemMasterDto) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			int itemNo = itemMasterDto.getItemNo();
			PreparedStatement ps = con.prepareStatement("select * from items where itemno=?");
			ps.setInt(1, itemNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ps = con.prepareStatement("update items set itemdesc=?,itemprice=?,itemunit=? where itemno=?");
				ps.setString(1, itemMasterDto.getItemDescription());
				ps.setDouble(2, itemMasterDto.getItemPrice());
				ps.setInt(3, itemMasterDto.getItemUnit());
				ps.setInt(4, itemMasterDto.getItemNo());
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
	public int deleteByItemNo(int itemNo) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from items where itemno=?");
			ps.setInt(1, itemNo);
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
		ItemMasterDao itemDao = new ItemMasterDaoImplementation();
		System.out.println(itemDao.findByItemNo(1));
		System.out.println(itemDao.getItemDescriptionByItemNo(2));
		System.out.println(itemDao.findAllItems());
		System.out.println(itemDao.getPriceByItemNo(1));
		System.out.println(itemDao.getPriceByItemNoAndQuantity(1, 5));
		
		ItemMasterDTO dto = new ItemMasterDTO();
		dto.setItemNo(1);
		dto.setItemDescription("chips");
		dto.setItemUnit(20);
		dto.setItemPrice(15);
		
		System.out.println(itemDao.updateItem(dto));
		System.out.println(itemDao.deleteByItemNo(3));
	}

}
