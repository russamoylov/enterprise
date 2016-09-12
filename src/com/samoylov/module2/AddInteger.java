package com.samoylov.module2;

public class AddInteger implements Task<Integer> {

    private int firstSummand;
    private int secondSummand;
    private int result;


    public AddInteger(int firstSummand, int secondSummand) {
        this.firstSummand = firstSummand;
        this.secondSummand = secondSummand;
    }


    @Override
    public void execute() {
        result = firstSummand + secondSummand;
    }


    @Override
    public Integer getResult() {
        return result;
    }
}