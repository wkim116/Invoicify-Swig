package com.invoicify.Invoices.models;

public class InvoiceView {

	private String invoiceDescription;
	private long[] recordIds;
	
	InvoiceView(){};
	InvoiceView(String invoiceDescription, long[] recordIds){
		this.invoiceDescription = invoiceDescription;
		this.recordIds = recordIds;
	}
	public String getInvoiceDescription() {
		return invoiceDescription;
	}
	public void setInvoiceDescription(String invoiceDescription) {
		this.invoiceDescription = invoiceDescription;
	}
	public long[] getRecordIds() {
		return recordIds;
	}
	public void setRecordIds(long[] recordIds) {
		this.recordIds = recordIds;
	}
}
