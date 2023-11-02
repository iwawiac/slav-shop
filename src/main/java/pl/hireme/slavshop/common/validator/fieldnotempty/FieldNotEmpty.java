package pl.hireme.slavshop.common.validator.fieldnotempty;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldCannotBeEmptyValidator.class)
public @interface FieldNotEmpty {

    String message() default "Field cannot be empty, please enter a valid value";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};

}
