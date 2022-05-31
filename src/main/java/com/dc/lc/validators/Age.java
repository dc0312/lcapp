package com.dc.lc.validators;

import com.dc.lc.validators.impl.AgeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AgeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {

    int lower() default 18;

    int upper() default 60;

    String message() default "Age must be between 18 - 60";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
