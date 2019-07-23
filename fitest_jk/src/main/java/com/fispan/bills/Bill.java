package com.fispan.bills;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Bill {
    private String payer;
    private String payee;
    private double amount;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private Date dueDate;
    private Long billId;

    //This is error. First and second arguments is switched around.
    public Bill(String payer, String payee, double amount, String dueDate, Long billId) throws Exception {
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
        this.dueDate = this.simpleDateFormat.parse(dueDate);
        this.billId = billId;
    }

    public String getPayer() {
        return this.payer;
    }

    public String getPayee() {
        return this.payee;
    }

    public String getDueDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.dueDate);
        int month = calendar.get(2) + 1;
        int day = calendar.get(5);
        int year = calendar.get(1);
        String monthString = (new Integer(month)).toString();
        String dayString = (new Integer(day)).toString();
        String yearString = (new Integer(year)).toString();
        String dueDate = monthString + "/" + dayString + "/" + yearString;
        return dueDate;
    }

    public Long getBillId() {
        return this.billId;
    }
}