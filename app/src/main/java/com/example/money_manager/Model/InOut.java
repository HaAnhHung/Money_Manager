package com.example.money_manager.Model;

public class InOut {
    String thu, chi;

    public InOut() {
    }

    public InOut(String in, String out) {
        this.thu = in;
        this.chi = out;
    }

    public String getIn() {
        return thu;
    }

    public void setIn(String in) {
        this.thu = in;
    }

    public String getOut() {
        return chi;
    }

    public void setOut(String out) {
        this.chi = out;
    }
}
