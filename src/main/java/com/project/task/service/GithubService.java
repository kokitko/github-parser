package com.project.task.service;

import com.project.task.dto.BranchDto;
import com.project.task.dto.GitHubBranchDto;
import com.project.task.dto.GitHubRepoDto;
import com.project.task.dto.RepoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubService {
    @Autowired
    private GitHubClient client;

    public List<RepoResponseDto> getNonForkRepositories(String username) {
        List<GitHubRepoDto> allRepos = client.getUserRepositories(username);
        return allRepos.stream()
                .filter(repo -> !repo.isFork())
                .map(repo -> {
                    List<GitHubBranchDto> branches = client.getBranches(repo.getOwner().getLogin(), repo.getName());
                    List<BranchDto> branchDtos = branches.stream()
                            .map(branch ->
                                    new BranchDto(branch.getName(), branch.getCommit().getSha())).toList();
                    return new RepoResponseDto(repo.getName(), repo.getOwner().getLogin(), branchDtos);
                })
                .toList();
    }
}
