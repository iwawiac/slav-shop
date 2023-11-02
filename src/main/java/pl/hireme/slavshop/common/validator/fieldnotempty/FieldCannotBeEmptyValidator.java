package pl.hireme.slavshop.common.validator.fieldnotempty;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class FieldCannotBeEmptyValidator implements ConstraintValidator<FieldNotEmpty, String> {

    @Override
    public void initialize(FieldNotEmpty constraintAnnotation) {}

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return !Objects.equals(field, "") && field != null;
    }

}
