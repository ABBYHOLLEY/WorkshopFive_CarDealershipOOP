package com.ps;

public abstract class SalesContract extends Contract{
    private String salesTax;
    private String recordingFee;
    private String processingFee;
    private boolean finance;
    private float monthlyPayment;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, String vehicleSold, String salesTax, String recordingFee, String processingFee, boolean finance) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.finance = finance;
    }

    public String getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(String salesTax) {
        this.salesTax = salesTax;
    }

    public String getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(String recordingFee) {
        this.recordingFee = recordingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    public String getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(String processingFee) {
        this.processingFee = processingFee;
    }
}
