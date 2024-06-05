package it.pi.registro.registro.validation;

import it.pi.registro.registro.annotation.AgeConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeValidation implements ConstraintValidator<AgeConstraint, LocalDate> {

    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 150;

    @Override
    public void initialize(AgeConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext context) {
        if (dateOfBirth == null) {
            // Date of birth is not provided, so it's not valid
            return false;
        }

        // Calculate age based on current date
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        int age = period.getYears();

        // Check if age falls within the desired range
        return age >= MIN_AGE && age <= MAX_AGE;
    }
}
