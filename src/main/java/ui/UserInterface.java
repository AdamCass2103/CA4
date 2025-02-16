package ui;
import services.ExpenseService;
import DTO.Expense;
import java.util.Scanner;
import java.util.Date;

public class UserInterface {
    private ExpenseService expenseService = new ExpenseService();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n1. List Expenses");
            System.out.println("2. Add Expense");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> listExpenses();
                case 2 -> addExpense();
                case 3 -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void listExpenses() {
        for (Expense e : expenseService.getAllExpenses()) {
            System.out.println(e.getTitle() + " - " + e.getAmount());
        }
    }

    private void addExpense() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        Expense expense = new Expense(0, title, category, amount, new Date());
        expenseService.addExpense(expense);
    }
}
