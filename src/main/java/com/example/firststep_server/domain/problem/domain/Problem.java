package com.example.firststep_server.domain.problem.domain;

import com.example.firststep_server.domain.problem.domain.enums.Category;
import com.example.firststep_server.domain.problem.presentation.dto.request.UpdateProblemRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false, length = 100)
    private String problem;

    @Column(length = 10)
    private String problemDetail;

    @Column(length = 10)
    private String answer;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    private String date;

    private boolean isCorrect;

    private String photoUrl;

    private String audioUrl;

    public void markAsWrong() {
        this.isCorrect = true;
    }

    public void markAsCorrect() {
        this.isCorrect = false;
    }

    public void updateProblem(UpdateProblemRequest updateProblemRequest) {
        this.category = updateProblemRequest.getCategory();
        this.date = updateProblemRequest.getDate();
        this.problem = updateProblemRequest.getProblem();
        this.problemDetail = updateProblemRequest.getProblemDetail();
        this.answer = updateProblemRequest.getAnswer();
        this.level = updateProblemRequest.getLevel();
        this.isCorrect = updateProblemRequest.isCorrect();
    }
}