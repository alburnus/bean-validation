package com.github.alburnus.resource;

import com.github.alburnus.entity.Team;
import com.github.alburnus.repository.TeamRepository;
import com.github.alburnus.validator.insert.InsertValidationGroup;
import com.github.alburnus.validator.update.UpdateValidationGroup;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TeamResource {

    private final TeamRepository teamRepository;

    public TeamResource(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostMapping(value = "/teams")
    public ResponseEntity<Team> save(@Validated(InsertValidationGroup.class) @RequestBody Team team) {
        team.setId(UUID.randomUUID().getMostSignificantBits());
        return ResponseEntity.ok(teamRepository.save(team));
    }

    @PutMapping(value = "/teams")
    public ResponseEntity<Team> update(@Validated(UpdateValidationGroup.class) @RequestBody Team team) {
        return ResponseEntity.ok(teamRepository.save(team));
    }

    @GetMapping(value = "/teams")
    public ResponseEntity<List<Team>> getAll() {
        List<Team> teams = teamRepository.findAll();
        return teams.size() > 0 ? ResponseEntity.ok(teams) : ResponseEntity.notFound().build();
    }
}
