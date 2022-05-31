package com.dc.lc.validators.impl;

import com.dc.lc.validators.Age;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

    private int lower;

    private  int upper;

    @Override
    public void initialize(Age age) {
        this.lower = age.lower();
        this.upper = age.upper();
    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        if(null == age){
            return false;
        }

        if(age <lower || age > upper){
            return false;
        }
        return true;
    }
}
