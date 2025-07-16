package com.example.firststep_server.domain.problem.presentation.dto.response;

import com.example.firststep_server.domain.problem.domain.enums.Category;

public record ProblemResponse(
        Long id,
        Category category,
        int level,
        String problem,
        String problemDetail,
        String date,
        String answer,
        String photoUrl,
        String audioUrl
) {
}
