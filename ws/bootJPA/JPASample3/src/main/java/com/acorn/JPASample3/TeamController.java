package com.acorn.JPASample3;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TeamController {

    private final TeamService teamService;
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // 팀 ID로 팀 조회
    @GetMapping("/teams/{teamId}")
    public Team  getTeamById(@PathVariable(name="teamId") Long teamId) {
        Team team = teamService.findTeamById(teamId);

        System.out.println("팀 정보" + team );
        System.out.println("팀 목록" + team.getMembers());
        // 팀이 존재하면 반환
        return team;
    }
}
