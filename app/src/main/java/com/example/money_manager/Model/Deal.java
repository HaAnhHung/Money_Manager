package com.example.money_manager.Model;

public class Deal {
    String money, group, note, in_out;

    public Deal() {
    }

    public Deal(String money, String group, String note, String in_out) {
        this.money = money;
        this.group = group;
        this.note = note;
        this.in_out = in_out;

    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getIn_out() {
        return in_out;
    }

    public void setIn_out(String in_out) {
        this.in_out = in_out;
    }
}
