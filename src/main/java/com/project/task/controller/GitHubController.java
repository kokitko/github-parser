package com.project.task.controller;

import com.project.task.dto.RepoResponseDto;
import com.project.task.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitHubController {
    @Autowired
    private GithubService githubService;

    @GetMapping("/api/github/{username}/repos")
    public ResponseEntity<List<RepoResponseDto>> getRepositories(@PathVariable String username) {
        List<RepoResponseDto> repositories = githubService.getNonForkRepositories(username);
        return ResponseEntity.ok(repositories);
    }
}
