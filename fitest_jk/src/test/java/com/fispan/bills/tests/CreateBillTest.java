package com.fispan.bills.tests;

import org.junit.*;

/**
 * Tests for BillManager
 */
public class CreateBillTest extends BaseTest
{
    @Test
    public void createValidBill() throws Exception
    {
        Long returnId = manageBills.createBill("Massive Dynamics", "Acme Corp", 70.00, "12/11/2014");
        assert (returnId != -1);
    }

    @Test (expected = Exception.class)
    public void createInvalidBillWithWrongDateFormat() throws Exception {
        Long returnId = manageBills.createBill("Massive Dynamics", "Acme Corp", 70.00, "1211/2014");
    }
}
