package DAO;

import DTO.Income;
import utils.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO {

    public void addIncome(Income income) {
        String sql = "INSERT INTO income (title, amount, dateEarned) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, income.getTitle());
            stmt.setDouble(2, income.getAmount());
            stmt.setDate(3, new java.sql.Date(income.getDateEarned().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Income> getAllIncome() {
        List<Income> incomeList = new ArrayList<>();
        String sql = "SELECT * FROM income";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                incomeList.add(new Income(
                        rs.getInt("incomeID"),
                        rs.getString("title"),
                        rs.getDouble("amount"),
                        rs.getDate("dateEarned")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incomeList;
    }

    public void deleteIncome(int id) {
        String sql = "DELETE FROM income WHERE incomeID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getTotalIncome() {
        String sql = "SELECT SUM(amount) AS total FROM income";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}