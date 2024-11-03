package com.ps;

public abstract class LeaseContract extends Contract{
    private float endingValue;
    private float leaseFee;
    private float monthlyPayment;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, String vehicleSold, float endingValue, float leaseFee) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.endingValue = endingValue;
        this.leaseFee = leaseFee;
    }

    public float getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(float endingValue) {
        this.endingValue = endingValue;
    }

    public float getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(float leaseFee) {
        this.leaseFee = leaseFee;
    }
}
