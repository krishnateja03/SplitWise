package dto;

import split.Split;

import java.util.List;

public class User {
    private Integer id;
    private String name;
    private double balance;
    private List<Expense> expenses;
    private List<Group> groups;
    private Split split;

    public User(Integer id, String name, double balance, List<Expense> expenses, List<Group> groups) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.expenses = expenses;
        this.groups = groups;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Split getSplit() {
        return split;
    }

    public void setSplit(Split split) {
        this.split = split;
    }
}
