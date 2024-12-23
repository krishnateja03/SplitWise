package service;

import dto.Expense;
import dto.Group;
import dto.User;

import java.util.List;

public interface SplitWiseService {
    void addUsers(List<User> asList);
    void createGroup(Group group);
    void addExpense(Expense expense, Group group);
    void settleExpense(Integer paidBy, Integer owingUser, Integer expenseId);
}
