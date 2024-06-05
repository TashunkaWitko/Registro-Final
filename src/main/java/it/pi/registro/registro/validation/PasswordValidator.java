package it.pi.registro.registro.validation;

import it.pi.registro.registro.annotation.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        // Check if password is not blank
        if (password == null || password.trim().isEmpty()) {
            return false;
        }

        // You can add more validation rules here if needed

        return true;
    }
}