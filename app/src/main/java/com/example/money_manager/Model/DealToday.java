package com.example.money_manager.Model;

public class DealToday {
    String group, money;

    public DealToday() {
    }

    public DealToday(String group, String money) {
        this.group = group;
        this.money = money;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
