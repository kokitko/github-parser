# GitHub Repository Parser

This project is a REST API built with **Java 21** and **Spring Boot 3.5**, which fetches a list of non-fork repositories for a given GitHub username and returns their branches with the latest commit SHA.

## Features

- Lists **all non-fork repositories** for a GitHub user.
- For each repository, returns:
  - Repository name
  - Owner login
  - All branches with:
    - Branch name
    - Last commit SHA
- Handles 404 response with a clear JSON error message if the user does not exist.

## Tech Stack

- Java 21
- Spring Boot 3.5
- Spring Web (RestTemplate)
- Spring Boot Test (integration testing via MockMvc)

## How it works

1. API accepts a GET request on `/api/github/{username}/repos`.
2. Internally calls GitHub REST API:
   - Gets all repositories for the user (`GET /users/{username}/repos`)
   - Filters out forked repositories
   - For each repo, fetches branches via `GET /repos/{owner}/{repo}/branches`
3. Maps and returns the result as a simplified JSON format.

### Example Output

```json
[
  {
    "repositoryName": "git-consortium",
    "ownerLogin": "octocat",
    "branches": [
      {
        "name": "master",
        "lastCommitSha": "b33a9c7c02ad93f621fa38f0e9fc9e867e12fa0e"
      }
    ]
  }
]
```

### Error Response

If the user doesn't exist:
```json
{
  "status": 404,
  "message": "User not found"
}
```

## How To Run

```
mvn spring-boot:run
```

## How To Test

Integration test is provided in:
```
src/test/java/com/project/task/controller/GitHubControllerTest.java
```
Test sends a real HTTP request and verifies the happy path response structure.

## Notes

Build for a recruitment task, scope is intentionally minimal.
