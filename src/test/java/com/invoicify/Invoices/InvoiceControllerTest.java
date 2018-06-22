package com.invoicify.Invoices;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.invoicify.Invoices.controllers.InvoiceController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceControllerTest {

	@Test
	public void testDefaultConstructor() {
		InvoiceController invoiceController = new InvoiceController();
		assertThat(invoiceController, instanceOf(InvoiceController.class));
	}
	
	

}
