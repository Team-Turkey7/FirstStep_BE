package com.example.firststep_server.domain.problem.presentation.dto.response;

import com.example.firststep_server.domain.problem.domain.UserIncorrectAnswer;
import com.example.firststep_server.domain.problem.domain.enums.Category;
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
    private Category category;
    private String problem;
    private String problemDetail;
    private String photoUrl;
    private String answer;

    public WrongProblemResponse(UserIncorrectAnswer userIncorrectAnswer) {
        this.id = userIncorrectAnswer.getId();
        this.date = userIncorrectAnswer.getDate();
        this.category = userIncorrectAnswer.getCategory();
        this.problem = userIncorrectAnswer.getProblem();
        this.problemDetail = userIncorrectAnswer.getProblemDetail();
        this.photoUrl = userIncorrectAnswer.getPhotoUrl();
        this.answer = userIncorrectAnswer.getAnswer();
    }
}
