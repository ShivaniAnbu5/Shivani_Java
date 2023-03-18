package daoproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import daoproject.dto.CustomerMasterDTO;
import daoproject.dto.InvoiceTransactionDTO;
import dbConnection.DBUtility;

public class InvoiceTransactionDaoImplementation extends InvoiceTransactionDao{

private static InvoiceTransactionDaoImplementation invoiceTransaction;
	
	private InvoiceTransactionDaoImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	public static InvoiceTransactionDaoImplementation InvoiceTransactionDaoImplementationObject() {
		if(invoiceTransaction == null) {
			invoiceTransaction = new InvoiceTransactionDaoImplementation();
			return invoiceTransaction;
		}
		else {
			return invoiceTransaction.createClone();
		}
	}
	
	private InvoiceTransactionDaoImplementation createClone() {
		if(invoiceTransaction!=null) {
			try {
				return (InvoiceTransactionDaoImplementation)super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		else return null;
	}

	@Override
	public InvoiceTransactionDTO findByInvoiceNo(int invoiceNo) {
		// TODO Auto-generated method stub
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from invoicetransaction where invoiceno=?");
			ps.setInt(1, invoiceNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				InvoiceTransactionDTO invoiceTransactionDTO=new InvoiceTransactionDTO();
				invoiceTransactionDTO.setInvoiceNo(rs.getInt("invoiceno"));
				invoiceTransactionDTO.setItemNo(rs.getInt("itemno"));
				invoiceTransactionDTO.setItemQuantity(rs.getInt("itemunit"));
				return invoiceTransactionDTO;
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
	public Collection<InvoiceTransactionDTO> findAllInvoiceTransactions() {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from invoicetransaction");
			List<InvoiceTransactionDTO> invoiceTransactions = new ArrayList<>();
			while(rs.next()) {
				InvoiceTransactionDTO invoiceTransactionDTO=new InvoiceTransactionDTO();
				invoiceTransactionDTO.setInvoiceNo(rs.getInt("invoiceno"));
				invoiceTransactionDTO.setItemNo(rs.getInt("itemno"));
				invoiceTransactionDTO.setItemQuantity(rs.getInt("itemunit"));
				invoiceTransactions.add(invoiceTransactionDTO);
			}
			return invoiceTransactions;

		}catch(Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int updateInvoiceTransaction(InvoiceTransactionDTO invoiceTransactionDTO) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			int invoiceNo = invoiceTransactionDTO.getInvoiceNo();
			PreparedStatement ps = con.prepareStatement("select * from invoicetransaction where invoiceno=?");
			ps.setInt(1, invoiceNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ps = con.prepareStatement("update invoicetransaction set itemno=?,itemunit=? where invoiceno=?");
				ps.setInt(1, invoiceTransactionDTO.getItemNo());
				ps.setInt(2, invoiceTransactionDTO.getItemQuantity());
				ps.setInt(3, invoiceNo);
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
	public int deleteTransactionByInvoiceNo(int invoiceNo) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from invoicetransaction where invoiceno=?");
			ps.setInt(1, invoiceNo);
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
		InvoiceTransactionDao invoiceTransactionDao = new InvoiceTransactionDaoImplementation();
		System.out.println(invoiceTransactionDao.findByInvoiceNo(1));
		System.out.println(invoiceTransactionDao.findAllInvoiceTransactions());
		
		InvoiceTransactionDTO invoiceTransactionDTO = new InvoiceTransactionDTO();
		invoiceTransactionDTO.setInvoiceNo(1);
		invoiceTransactionDTO.setItemNo(1);
		invoiceTransactionDTO.setItemQuantity(2);
		System.out.println(invoiceTransactionDao.updateInvoiceTransaction(invoiceTransactionDTO));
		
		System.out.println(invoiceTransactionDao.deleteTransactionByInvoiceNo(2));
	}
}
