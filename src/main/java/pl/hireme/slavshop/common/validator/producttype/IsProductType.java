package pl.hireme.slavshop.common.validator.producttype;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductTypeValidator.class)
public @interface IsProductType {
    String message() default "Valid product type required. Allowed types are: AUDIO, VIDEO, BOOK" ;
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};

}
