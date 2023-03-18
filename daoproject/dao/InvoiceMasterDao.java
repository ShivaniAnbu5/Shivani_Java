package daoproject.dao;
import java.util.Collection;

import daoproject.dto.InvoiceMasterDTO;
public abstract class InvoiceMasterDao {
	public abstract Collection<InvoiceMasterDTO> findAllInvoiceMasters();
	public abstract int findCustIdByInvoiceNo(int invoiceNo);
	public abstract Collection<Integer> findInvoiceNosByDate(String date);
	public abstract Collection<Integer> findInvoiceNosByCustId(int custId);
	public abstract int updateInvoiceMasterByInvoiceNo(InvoiceMasterDTO invoiceMasterDTO);
	public abstract int deleteInvoiceMasterByInvoiceNo(int invoiceNo);
}
