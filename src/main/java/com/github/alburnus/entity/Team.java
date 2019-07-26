package com.github.alburnus.entity;

import com.github.alburnus.validator.insert.InsertValidationGroup;
import com.github.alburnus.validator.update.UpdateValidationGroup;
import com.github.alburnus.validator.update.NeedToHasId;
import com.github.alburnus.validator.team.common.TeamNameUniqueness;
import com.github.alburnus.validator.insert.CanNotHasId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @CanNotHasId(groups = {InsertValidationGroup.class})
    @NeedToHasId(groups = {UpdateValidationGroup.class})
    private Long id;

    @TeamNameUniqueness
    private String name;
}
