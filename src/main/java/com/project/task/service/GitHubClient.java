package com.project.task.service;

import com.project.task.dto.GitHubBranchDto;
import com.project.task.dto.GitHubRepoDto;
import com.project.task.exceptions.UserNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class GitHubClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public List<GitHubRepoDto> getUserRepositories(String username) {
        String url = "https://api.github.com/users/" + username + "/repos";
        try {
            GitHubRepoDto[] repos = restTemplate.getForObject(url, GitHubRepoDto[].class);
            return List.of(repos);
        } catch (HttpClientErrorException.NotFound e) {
            throw new UserNotFoundException("User not found.");
        }
    }

    public List<GitHubBranchDto> getBranches(String username, String repoName) {
        String url = "https://api.github.com/repos/" + username + "/" + repoName + "/branches";
        GitHubBranchDto[] branches = restTemplate.getForObject(url, GitHubBranchDto[].class);
        return List.of(branches);
    }
}
