package com.fispan.bills;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;


public class ManageBills
{
    private static ManageBills instance = null;
    private HashMap<Long, Bill> bills = new HashMap(); //Could I make this static? Personally, I see no harm doing so. If so,
                                                       //I did not have to run createBill on GetBillTest
    private Random randomize = new Random();

    private ManageBills() {
    }

    public static ManageBills getInstance() {
        if (instance == null) {
            instance = new ManageBills();
        }
        return instance;
    }

    public Long createBill(String payee, String payer, double amount, String dueDate) throws Exception {
        Long returnNumber = new Long(-1L);
        if ( amount > 0) {
            Long billId = Math.abs(this.randomize.nextLong());
            Bill newBill = new Bill(payee, payer, amount, dueDate, billId);
            this.bills.put(billId, newBill);
            returnNumber = newBill.getBillId();
        }

        return returnNumber;
    }

    public Bill getBill(Long billId) {
        Bill retrievedBill = (Bill)this.bills.get(billId);
        return retrievedBill;
    }

    public Collection<Bill> getAllBills() {
        return this.bills.values();
    }

    public String updateBill(Long billId, String newPayee, String newPayer, double newAmount, String newDueDate) throws Exception {
        String returnMessage = "Could not update Bill.";
        if (this.bills.containsKey(billId)) {
            Bill bill = new Bill(newPayee, newPayer, newAmount, newDueDate, billId);
            this.bills.replace(billId, bill);
            returnMessage = "Bill successfully updated.";
        } else {
            returnMessage = returnMessage + " Such bill does not exist.";
        }

        return returnMessage;
    }
}