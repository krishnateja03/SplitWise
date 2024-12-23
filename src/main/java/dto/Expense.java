package dto;

import split.Split;

public class Expense {
    private Integer expenseId;
    private Group groupId;
    private double amount;
    private Split split;
    private User paidBy;
    private String name;

    public Expense(Integer expenseId, Group groupId, double amount, User paidBy, String name) {
        this.expenseId = expenseId;
        this.groupId = groupId;
        this.amount = amount;
        this.paidBy = paidBy;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public Group getGroupId() {
        return groupId;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Split getSplit() {
        return split;
    }

    public void setSplit(Split split) {
        this.split = split;
    }

    public User getPaidBy() {
        return paidBy;
    }
}
