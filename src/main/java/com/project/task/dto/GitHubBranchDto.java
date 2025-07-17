package com.project.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GitHubBranchDto {
    private String name;
    private GitHubCommitDto commit;
}
