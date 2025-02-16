package services;

import DAO.IncomeDAO;
import DTO.Income;
import java.util.List;

public class IncomeService {
    private IncomeDAO incomeDAO = new IncomeDAO();

    public void addIncome(Income income) {
        incomeDAO.addIncome(income);
    }

    public List<Income> getAllIncome() {
        return incomeDAO.getAllIncome();
    }

    public void deleteIncome(int id) {
        incomeDAO.deleteIncome(id);
    }

    public double getTotalIncome() {
        return incomeDAO.getTotalIncome();
    }
}