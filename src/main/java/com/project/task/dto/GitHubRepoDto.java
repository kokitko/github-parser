package com.project.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GitHubRepoDto {
    private String name;
    private GithubUserDto owner;
    private boolean fork;
}
