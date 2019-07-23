package com.fispan.bills.tests;

import org.junit.Before;
import org.junit.Test;

public class GetAllBillsTest extends BaseTest {

    @Before
    public void createBills() throws Exception {
        Long returnId = manageBills.createBill("Massive Dynamics", "Acme Corp", 70.00, "12/11/2014");
    }

    @Test
    public void getAllBillsTest() {
        assert (manageBills.getAllBills().size() == 1);
    }
}
