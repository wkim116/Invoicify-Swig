package com.invoicify.Invoices;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.invoicify.Invoices.controllers.FlatFeeBillingRecordController;


	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class FlatFeeBillingRecordControllerTest {
	
	@Test
	public void testFlatFeeBillingRecordControllerConstructor() {
		FlatFeeBillingRecordController FlatFeeBill = new FlatFeeBillingRecordController();
	assertThat(FlatFeeBill, instanceOf(FlatFeeBillingRecordController.class));
	}
}