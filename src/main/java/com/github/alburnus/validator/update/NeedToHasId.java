package com.github.alburnus.validator.update;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NeedToHasIdValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedToHasId {
    String message() default "Object need to has ID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
