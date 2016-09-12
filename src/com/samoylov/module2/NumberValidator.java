package com.samoylov.module2;


public class NumberValidator implements Validator<Number> {


    @Override
    public boolean isValid(Number value) {

        if (value.intValue() <= 0) {
            return false;
        }
        return true;
    }
}
