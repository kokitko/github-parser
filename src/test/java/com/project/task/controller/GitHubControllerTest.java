package com.project.task.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GitHubControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnRepositoriesWithBranches() throws Exception {
        mockMvc.perform(get("/api/github/octocat/repos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].repositoryName").isNotEmpty())
                .andExpect(jsonPath("$[0].ownerLogin").value("octocat"))
                .andExpect(jsonPath("$[0].branches").isArray())
                .andExpect(jsonPath("$[0].branches[0].name").isNotEmpty())
                .andExpect(jsonPath("$[0].branches[0].lastCommitSha").isNotEmpty());
    }
}
