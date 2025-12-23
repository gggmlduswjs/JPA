package com.acorn.JPASample3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TeamService {


    @Autowired
    TeamRepository teamRepository;


    public Team  findTeamById(Long teamId) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        return  teamOptional.orElse(null);

    }
}
