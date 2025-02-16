package org.example;
import DTO.Expense;
import DTO.Income;
import services.ExpenseService;
import services.IncomeService;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Main {
    private static ExpenseService expenseService = new ExpenseService();
    private static IncomeService incomeService = new IncomeService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Finance Tracker ===");
            System.out.println("1. List all expenses & total spend");
            System.out.println("2. Add a new expense");
            System.out.println("3. Delete an expense");
            System.out.println("4. List all income & total income");
            System.out.println("5. Add new income");
            System.out.println("6. Delete income");
            System.out.println("7. View monthly report");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                listExpenses();
            } else if (choice == 2) {
                addExpense();
            }  else if (choice == 3) {
                listIncome();
            } else if (choice == 4) {
                addIncome();
            } else if (choice == 5) {
                deleteIncome();
            } else if (choice == 6) {
                viewMonthlyReport();
            } else if (choice == 8) {
                System.out.println("Exiting program...");
                System.exit(0);
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void listExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        double total = 0;
        System.out.println("\n--- Expenses ---");
        for (Expense e : expenses) {
            System.out.println(e.getTitle() + " - €" + e.getAmount());
            total += e.getAmount();
        }
        System.out.println("Total Spent: €" + total);
    }

    private static void addExpense() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        expenseService.addExpense(new Expense(0, title, category, amount, new Date()));
        System.out.println("Expense added.");
    }



    private static void listIncome() {
        List<Income> incomeList = incomeService.getAllIncome();
        double total = 0;
        System.out.println("\n--- Income ---");
        for (Income i : incomeList) {
            System.out.println(i.getTitle() + " - €" + i.getAmount());
            total += i.getAmount();
        }
        System.out.println("Total Income: €" + total);
    }

    private static void addIncome() {
        System.out.print("Enter income title: ");
        String title = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        incomeService.addIncome(new Income(0, title, amount, new Date()));
        System.out.println("Income added.");
    }

    private static void deleteIncome() {
        System.out.print("Enter income ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        incomeService.deleteIncome(id);
        System.out.println("Income deleted.");
    }

    private static void viewMonthlyReport() {
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        scanner.nextLine();

        List<Expense> expenses = expenseService.getAllExpenses();
        List<Income> incomeList = incomeService.getAllIncome();

        double totalExpenses = expenses.stream()
                .filter(e -> e.getDateIncurred().getMonth() + 1 == month)
                .mapToDouble(Expense::getAmount)
                .sum();

        double totalIncome = incomeList.stream()
                .filter(i -> i.getDateEarned().getMonth() + 1 == month)
                .mapToDouble(Income::getAmount)
                .sum();

        double balance = totalIncome - totalExpenses;

        System.out.println("\n--- Monthly Report for Month " + month + " ---");
        System.out.println("Total Income: €" + totalIncome);
        System.out.println("Total Expenses: €" + totalExpenses);
        System.out.println("Balance: €" + balance);
    }
}