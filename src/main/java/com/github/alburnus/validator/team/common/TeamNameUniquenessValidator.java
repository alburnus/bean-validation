package com.github.alburnus.validator.team.common;

import com.github.alburnus.entity.Team;
import com.github.alburnus.repository.TeamRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class TeamNameUniquenessValidator implements ConstraintValidator<TeamNameUniqueness, String> {

    private final TeamRepository teamRepository;

    public TeamNameUniquenessValidator(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void initialize(TeamNameUniqueness constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Team> found = teamRepository.findByName(value);
        if (found.isPresent()) {
            return false;
        }
        return true;
    }
}
