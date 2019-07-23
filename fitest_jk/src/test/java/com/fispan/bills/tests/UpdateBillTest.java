package com.fispan.bills.tests;

import com.fispan.bills.Bill;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UpdateBillTest extends BaseTest {

    @Test
    public void updateBillAndValidateUpdatedBillTest() throws Exception {
        Long returnId = manageBills.createBill("Massive Dynamics", "Acme Corp", 70.00, "12/11/2014");
        assertEquals(manageBills.updateBill(returnId, "Passive Dynamics",
                "Acne Corp", 9000.00, "12/17/2020"), "Bill successfully updated.");
        Bill billToTest = manageBills.getBill(returnId);
        assertEquals(billToTest.getPayee(), "Acne Corp"); //should be payer
        assertEquals(billToTest.getPayer(), "Passive Dynamics"); //should be payee
        assertEquals(billToTest.getDueDate(), "12/17/2020");
    }

    @Test
    public void updateBillWithInvalidBillIdTest() throws Exception {
        Long returnId = manageBills.createBill("Massive Dynamics", "Acme Corp", 70.00, "12/11/2014");
        assertEquals(manageBills.updateBill(0L, "Passive Dynamics",
                "Acne Corp", 9000.00, "12/17/2020"), "Could not update Bill." +
                " Such bill does not exist.");
    }
}
