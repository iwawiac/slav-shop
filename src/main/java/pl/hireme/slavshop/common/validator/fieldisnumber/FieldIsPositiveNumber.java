package pl.hireme.slavshop.common.validator.fieldisnumber;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldIsPositiveNumberValidator.class)
public @interface FieldIsPositiveNumber {
    String message() default "Field must be a positive number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
