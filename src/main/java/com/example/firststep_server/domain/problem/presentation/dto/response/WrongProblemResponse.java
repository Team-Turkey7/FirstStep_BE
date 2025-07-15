package com.example.firststep_server.domain.problem.presentation.dto.response;

import com.example.firststep_server.domain.problem.domain.UserIncorrectAnswer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WrongProblemResponse {
    private Long id;
    private String date;
    private String problem;
    private String problemDetail;

    public WrongProblemResponse(UserIncorrectAnswer userIncorrectAnswer) {
        this.id = userIncorrectAnswer.getId();
        this.date = userIncorrectAnswer.getDate();
        this.problem = userIncorrectAnswer.getProblem();
        this.problemDetail = userIncorrectAnswer.getProblemDetail();
    }
}
