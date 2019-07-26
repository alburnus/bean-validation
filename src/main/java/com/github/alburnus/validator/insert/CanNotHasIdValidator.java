package com.github.alburnus.validator.insert;

import com.github.alburnus.validator.insert.CanNotHasId;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class CanNotHasIdValidator implements ConstraintValidator<CanNotHasId, Long> {

    public boolean isValid(Long id, ConstraintValidatorContext context) {
        log.info("Validation: " + id);
        if (id == null || id < 1) {
            return true;
        }
        return false;
    }
}
