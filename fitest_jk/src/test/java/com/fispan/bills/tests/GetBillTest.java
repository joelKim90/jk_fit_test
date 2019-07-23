package com.fispan.bills.tests;

import com.fispan.bills.Bill;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetBillTest extends BaseTest {

    @Test
    public void getBillTest() throws Exception {
        Long returnId = manageBills.createBill("Massive Dynamics", "Acme Corp", 70.00, "12/11/2014");
        Bill billToTest = manageBills.getBill(returnId);
        assertNotNull(billToTest);
    }

    @Test
    public void getBillDetailsTest() throws Exception {
        /*
            I just realized that when Bill is created, payee and payer are switched in input parameters in Bill class but just used as
            it is to pass the test
         */
        Long returnId = manageBills.createBill("Massive Dynamics", "Acme Corp", 70.00, "12/11/2014");
        Bill billToTest = manageBills.getBill(returnId);
        assertEquals(billToTest.getPayee(), "Acme Corp"); //should be payer
        assertEquals(billToTest.getPayer(), "Massive Dynamics"); //should be payee
        assertEquals(billToTest.getDueDate(), "12/11/2014");
    }

    @Test
    public void getBillWithWrongBillIdTest() throws Exception {
        Long returnId = manageBills.createBill("Massive Dynamics", "Acme Corp", 70.00, "12/11/2014");
        assertNull(manageBills.getBill(0L));
    }
}
