package com.genstream6214;

public class Salary implements Message<Integer> {

    private String from;
    private String to;
    private Integer salary;

    public Salary(String from, String to, Integer salary) {
        this.from = from;
        this.to = to;
        this.salary = salary;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public Integer getContent() {
        return salary;
    }

}
