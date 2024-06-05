package it.pi.registro.registro.validation;

import it.pi.registro.registro.annotation.NotZeroAndPositive;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotNegativeAndNotZeroValidator implements ConstraintValidator<NotZeroAndPositive, Long> {
    @Override
    public void initialize(NotZeroAndPositive constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value != null && value > 0;
    }
}
