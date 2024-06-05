package it.pi.registro.registro.annotation;

import it.pi.registro.registro.constant.Validation;
import it.pi.registro.registro.validation.NotNegativeAndNotZeroValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNegativeAndNotZeroValidator.class)
public @interface NotZeroAndPositive {
    String message() default Validation.NOT_POSITIVE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
