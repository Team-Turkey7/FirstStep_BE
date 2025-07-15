package com.example.firststep_server.domain.problem.presentation.dto.request;

import com.example.firststep_server.domain.problem.domain.enums.Category;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateProblemRequest {

    private Category category;
    private String date;
    private String problem;
    private String problemDetail;
    private boolean isCorrect;
    private String photoUrl;
    private String audioUrl;
}