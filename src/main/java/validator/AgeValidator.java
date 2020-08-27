package validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<CustomAge, String> {

	@Override
	public void initialize(CustomAge constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String age, ConstraintValidatorContext contextValid) {
	
		if (age.matches("//d")) {
			
			return true;
		}else {
			return false;
		}
	}

}
