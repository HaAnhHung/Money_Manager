package com.example.money_manager.Model;

public class Statistic {
    String date, icome, expenses;

    public Statistic() {
    }

    public Statistic(String date, String icome, String expenses, String total) {
        this.date = date;
        this.icome = icome;
        this.expenses = expenses;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIcome() {
        return icome;
    }

    public void setIcome(String icome) {
        this.icome = icome;
    }

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }
}
