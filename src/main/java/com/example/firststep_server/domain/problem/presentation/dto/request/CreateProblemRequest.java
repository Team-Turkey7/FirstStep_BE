package com.example.firststep_server.domain.problem.presentation.dto.request;

import com.example.firststep_server.domain.problem.domain.enums.Category;
import lombok.Getter;

@Getter
public class CreateProblemRequest {
    private Category category;
    private String date;
    private String problem;
    private String problemDetail;
    private String photoUrl;
}