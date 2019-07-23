package com.fispan.bills.tests;

import com.fispan.bills.ManageBills;
import org.junit.Before;

public class BaseTest {
    protected static ManageBills manageBills;

    @Before
    public void setUpTest() throws Exception
    {
        // Executed before each test
        manageBills = ManageBills.getInstance();
    }
}
