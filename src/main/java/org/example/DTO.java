package org.example;
import java.sql.Date;

public class ExpenseDTO {
    private int expenseID;
    private String title;
    private String category;
    private double amount;
    private Date dateIncurred;

    public ExpenseDTO(int expenseID, String title, String category, double amount, Date dateIncurred) {
        this.expenseID = expenseID;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }

    // Getters and setters
}