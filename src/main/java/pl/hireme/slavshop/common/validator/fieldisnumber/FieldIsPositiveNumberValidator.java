package pl.hireme.slavshop.common.validator.fieldisnumber;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FieldIsPositiveNumberValidator implements ConstraintValidator<FieldIsPositiveNumber, String> {

    @Override
    public void initialize(FieldIsPositiveNumber constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        try {
            return Double.parseDouble(value) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
