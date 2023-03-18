package daoproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import daoproject.dto.CustomerMasterDTO;
import daoproject.dto.InvoiceMasterDTO;
import dbConnection.DBUtility;

public class InvoiceMasterDaoImplementation extends InvoiceMasterDao {

	private static InvoiceMasterDaoImplementation invoiceMaster;

	private InvoiceMasterDaoImplementation() {
		// TODO Auto-generated constructor stub
	}

	public static InvoiceMasterDaoImplementation InvoiceMasterDaoImplementationObject() {
		if (invoiceMaster == null) {
			invoiceMaster = new InvoiceMasterDaoImplementation();
			return invoiceMaster;
		} else {
			return invoiceMaster.createClone();
		}
	}

	private InvoiceMasterDaoImplementation createClone() {
		if (invoiceMaster != null) {
			try {
				return (InvoiceMasterDaoImplementation) super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		} else
			return null;
	}

	@Override
	public Collection<InvoiceMasterDTO> findAllInvoiceMasters() {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from invoicemaster");
			List<InvoiceMasterDTO> invoicemasters = new ArrayList<>();
			while (rs.next()) {
				InvoiceMasterDTO invoiceMasterDto = new InvoiceMasterDTO();
				invoiceMasterDto.setInvoiceNo(rs.getInt("invoiceno"));
				invoiceMasterDto.setDate(rs.getString("date"));
				invoiceMasterDto.setCustomerId(rs.getInt("custid"));
				invoicemasters.add(invoiceMasterDto);
			}
			return invoicemasters;

		} catch (Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int findCustIdByInvoiceNo(int invoiceNo) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select custid from invoicemaster where invoiceno=?");
			ps.setInt(1, invoiceNo);
			ResultSet rs = ps.executeQuery();
			int n=0;
			if (rs.next()) {
				n = rs.getInt("custid");
			}
			
			return n;

		} catch (Exception e) {
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public Collection<Integer> findInvoiceNosByDate(String date) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select invoiceno from invoicemaster where date=?");
			ps.setString(1, date);
			ResultSet rs = ps.executeQuery();
			List<Integer> invoiceNumbers = new ArrayList<>();
			while (rs.next()) {
				int invoiceNo = rs.getInt("invoiceno");
				invoiceNumbers.add(invoiceNo);
			}
			return invoiceNumbers;

		} catch (Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public Collection<Integer> findInvoiceNosByCustId(int custId) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select invoiceno from invoicemaster where custid=?");
			ps.setInt(1, custId);
			ResultSet rs = ps.executeQuery();
			List<Integer> invoiceNumbers = new ArrayList<>();
			while (rs.next()) {
				int invoiceNo = rs.getInt("invoiceno");
				invoiceNumbers.add(invoiceNo);
			}
			return invoiceNumbers;

		} catch (Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public int updateInvoiceMasterByInvoiceNo(InvoiceMasterDTO invoiceMasterDTO) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			int invoiceNo = invoiceMasterDTO.getInvoiceNo();
			PreparedStatement ps = con.prepareStatement("select * from invoicemaster where invoiceno=?");
			ps.setInt(1, invoiceNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ps = con.prepareStatement("update invoicemaster set date=?,custid=? where invoiceno=?");
				ps.setString(1, invoiceMasterDTO.getDate());
				ps.setInt(2, invoiceMasterDTO.getCustomerId());
				ps.setInt(3, invoiceNo);
				int n = ps.executeUpdate();
				DBUtility.closeConnection(null);
				return n;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public int deleteInvoiceMasterByInvoiceNo(int invoiceNo) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from invoicemaster where invoiceno=?");
			ps.setInt(1, invoiceNo);
			int n = ps.executeUpdate();
			DBUtility.closeConnection(null);
			return n;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	public static void main(String[] args) {

		InvoiceMasterDao invoiceMasterDao = new InvoiceMasterDaoImplementation();

		System.out.println(invoiceMasterDao.findAllInvoiceMasters());
		System.out.println(invoiceMasterDao.findCustIdByInvoiceNo(12231));
		System.out.println(invoiceMasterDao.findInvoiceNosByCustId(1));
		System.out.println(invoiceMasterDao.findInvoiceNosByDate("21.06.2019"));
		
		InvoiceMasterDTO invoiceMasterDTO = new InvoiceMasterDTO();
		invoiceMasterDTO.setInvoiceNo(1);
		invoiceMasterDTO.setDate("21.06.2019");
		invoiceMasterDTO.setCustomerId(1);
		
		System.out.println(invoiceMasterDao.updateInvoiceMasterByInvoiceNo(invoiceMasterDTO));
		System.out.println(invoiceMasterDao.deleteInvoiceMasterByInvoiceNo(1));
	}

}
