package com.example.firststep_server.domain.problem.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;

public class AnswerJudgementRequest {
    private Long problemId;

    @NotBlank
    private String userAnswer;
}
