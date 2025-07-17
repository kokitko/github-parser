package com.project.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class RepoResponseDto {
    private String repositoryName;
    private String ownerLogin;
    private List<BranchDto> branches;
}
