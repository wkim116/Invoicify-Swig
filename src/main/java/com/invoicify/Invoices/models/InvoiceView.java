package com.invoicify.Invoices.models;

public class InvoiceView {

	private String invoiceDescription;
	private int[] recordIds;
	
	InvoiceView(){};
	InvoiceView(String invoiceDescription, int[] recordIds){
		this.invoiceDescription = invoiceDescription;
		this.recordIds = recordIds;
	}
	public String getInvoiceDescription() {
		return invoiceDescription;
	}
	public void setInvoiceDescription(String invoiceDescription) {
		this.invoiceDescription = invoiceDescription;
	}
	public int[] getRecordIds() {
		return recordIds;
	}
	public void setRecordIds(int[] recordIds) {
		this.recordIds = recordIds;
	}
}
