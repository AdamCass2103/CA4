package services;

import DAO.ExpenseDAO;
import DTO.Expense;

import java.util.List;

public class ExpenseService {
    private ExpenseDAO expenseDAO = new ExpenseDAO();

    public void addExpense(Expense expense) {
        expenseDAO.addExpense(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseDAO.getAllExpenses();
    }

}