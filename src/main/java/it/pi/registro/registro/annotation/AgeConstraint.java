package it.pi.registro.registro.annotation;

import it.pi.registro.registro.validation.AgeValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidation.class)
public @interface AgeConstraint {
    String message() default "Invalid age. Age must be between 18 and 150 years.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
