package DTO;

import java.util.Date;

public class Income {
    private int incomeID;
    private String title;
    private double amount;
    private Date dateEarned;

    public Income(int incomeID, String title, double amount, Date dateEarned) {
        this.incomeID = incomeID;
        this.title = title;
        this.amount = amount;
        this.dateEarned = dateEarned;
    }

    // Getters and Setters

    //Getters
    public int getIncomeID() {
        return incomeID;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDateEarned() {
        return dateEarned;
    }
    //Setters


    public void setIncomeID(int incomeID) {
        this.incomeID = incomeID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDateEarned(Date dateEarned) {
        this.dateEarned = dateEarned;
    }
}