package daoproject.dao;

import java.util.Collection;

import daoproject.dto.InvoiceTransactionDTO;

public abstract class InvoiceTransactionDao {

	public abstract InvoiceTransactionDTO findByInvoiceNo(int invoiceNo);
	public abstract Collection<InvoiceTransactionDTO> findAllInvoiceTransactions();
	public abstract int updateInvoiceTransaction(InvoiceTransactionDTO invoiceTransactionDTO);
	public abstract int deleteTransactionByInvoiceNo(int invoiceNo);
	
	
}
