package service;

import dto.Expense;
import dto.Group;
import dto.User;
import split.EqualSplit;
import split.PercentSplit;
import split.Split;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitWiseServiceImpl implements SplitWiseService {

    private Map<Integer, User> userMap;
    private Map<Integer, Group> groupMap;
    private Map<Integer, Expense> expenseMap;

    public SplitWiseServiceImpl() {
        this.userMap = new HashMap<>();
        this.groupMap = new HashMap<>();
        this.expenseMap = new HashMap<>();
    }

    @Override
    public void addUsers(List<User> users) {
        for(User user : users) {
            userMap.put(user.getId(), user);
        }
    }

    @Override
    public void createGroup(Group group) {
        if(!groupMap.containsKey(group.getId())) {
            groupMap.put(group.getId(), group);
        } else {
            System.out.println("Group with name :" + group.getName() + " already exists");
        }
    }

    @Override
    public void addExpense(Expense expense, Group group) {
        for(User user : group.getUsers()) {
            double amount = calculateUserShare(user, expense.getAmount(), group.getUsers().size());
            if(expense.getPaidBy().getId() == user.getId()) {
                updateBalance(user.getId(), -amount);
            } else {
                updateBalance(user.getId(), amount);
                System.out.println("Group " + group.getName() + " :: User " + user.getName() + " owes " + expense.getPaidBy().getName() + " Rs." + userMap.get(user.getId()).getBalance());
            }
        }
        expenseMap.putIfAbsent(expense.getExpenseId(), expense);
    }

    private void updateBalance(Integer id, double amount) {
        userMap.get(id).setBalance(userMap.get(id).getBalance()+amount);
    }

    private double calculateUserShare(User user, double amount, int size) {
        Split split = user.getSplit();
        double splitAmount = amount/size;
        if(split instanceof EqualSplit) {
            return splitAmount;
        } else if (split instanceof PercentSplit) {
            return amount*((PercentSplit) split).getPercentage()/100.0;
        }
        return 0.0d;
    }

    @Override
    public void settleExpense(Integer paidBy, Integer owingUser, Integer expenseId) {
        Expense expense = expenseMap.get(expenseId);
        userMap.get(paidBy).setBalance(0.0d);
        userMap.get(owingUser).setBalance(0.0d);
        System.out.println("Group " + expense.getGroupId().getName() + " :: User " + userMap.get(owingUser).getName() + " settled the " + expense.getName() +" expenses");
        System.out.println("Group " + expense.getGroupId().getName() + " :: User " + userMap.get(owingUser).getName() + " owes Rs." + userMap.get(owingUser).getBalance());
    }


}