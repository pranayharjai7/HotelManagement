package com.pranayharjai.hotelmanagement.Models;

import javax.persistence.*;

@Entity
public class BillData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(optional = false)
    private String billId;

    @Basic(optional = false)
    private int amount;

    @Basic(optional = false)
    private String billStatus;

    @Basic(optional = false)
    private int customerDataId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public int getCustomerDataId() {
        return customerDataId;
    }

    public void setCustomerDataId(int customerDataId) {
        this.customerDataId = customerDataId;
    }
}
