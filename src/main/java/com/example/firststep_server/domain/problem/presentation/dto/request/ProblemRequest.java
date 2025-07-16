package com.example.firststep_server.domain.problem.presentation.dto.request;

import com.example.firststep_server.domain.problem.domain.enums.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class ProblemRequest {

    @Enumerated(EnumType.STRING)
    private Category category;

    private String date;
}
