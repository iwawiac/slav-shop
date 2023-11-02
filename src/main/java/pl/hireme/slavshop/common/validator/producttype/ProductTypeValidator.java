package pl.hireme.slavshop.common.validator.producttype;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.hireme.slavshop.products.ProductType;

public class ProductTypeValidator implements ConstraintValidator<IsProductType, String> {

    @Override
    public void initialize(IsProductType constraintAnnotation) {}

    @Override
    public boolean isValid(String productTypeDTO, ConstraintValidatorContext constraintValidatorContext) {
        for(ProductType productType : ProductType.values()) {
            if(productType.toString().equals(productTypeDTO)){
                return true;
            }
        }
        return false;
    }

}
