package com.pranayharjai.hotelmanagement.Models;

import javax.persistence.*;

@Entity
public class CustomerData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private String typeOfId;
    @Basic(optional = false)
    private String idNumber;
    @Basic(optional = false)
    private String noOfAdditionalMembers;
    @Basic(optional = false)
    private String pets;
    @Basic(optional = false)
    private String petTag;
    @Basic(optional = false)
    private String checkInDate;
    @Basic(optional = false)
    private String checkOutDate;
    @Basic(optional = false)
    private String roomNumber;
    @Basic(optional = false)
    private String status;
    @Basic(optional = false)
    private String billId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfId() {
        return typeOfId;
    }

    public void setTypeOfId(String typeOfId) {
        this.typeOfId = typeOfId;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getNoOfAdditionalMembers() {
        return noOfAdditionalMembers;
    }

    public void setNoOfAdditionalMembers(String noOfAdditionalMembers) {
        this.noOfAdditionalMembers = noOfAdditionalMembers;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public String getPetTag() {
        return petTag;
    }

    public void setPetTag(String petTag) {
        this.petTag = petTag;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }
}
