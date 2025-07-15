package com.example.firststep_server.domain.problem.presentation.dto.response;

public record ProblemResponse(
        Long problemId,
        int level,
        String problemContent,
        String problemDetail,
        String date,
        String photoUrl,
        String audioUrl
) {
}
