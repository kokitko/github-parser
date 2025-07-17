package com.project.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BranchDto {
    private String name;
    private String lastCommitSha;
}
