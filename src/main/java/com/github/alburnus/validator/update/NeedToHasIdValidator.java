package com.github.alburnus.validator.update;

import com.github.alburnus.validator.update.NeedToHasId;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class NeedToHasIdValidator implements ConstraintValidator<NeedToHasId, Long> {

    public boolean isValid(Long id, ConstraintValidatorContext context) {
        log.info("Validation: " + id);
        if (id == null || id < 1) {
            return false;
        }
        return true;
    }
}
