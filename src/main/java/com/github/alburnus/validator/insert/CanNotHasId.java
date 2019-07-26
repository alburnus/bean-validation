package com.github.alburnus.validator.insert;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CanNotHasIdValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CanNotHasId {
    String message() default "Object shouldn't have id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
