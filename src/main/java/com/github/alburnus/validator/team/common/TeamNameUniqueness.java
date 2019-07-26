package com.github.alburnus.validator.team.common;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TeamNameUniquenessValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TeamNameUniqueness {
    String message() default "Team name need to be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
