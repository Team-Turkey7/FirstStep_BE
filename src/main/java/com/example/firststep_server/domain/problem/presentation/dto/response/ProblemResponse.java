package com.example.firststep_server.domain.problem.presentation.dto.response;

public record ProblemResponse(
        Long id,
        int level,
        String problem,
        String problemDetail,
        String date,
        String photoUrl,
        String audioUrl
) {
}
