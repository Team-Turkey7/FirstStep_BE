package com.example.firststep_server.domain.problem.domain;

import com.example.firststep_server.domain.problem.domain.enums.Category;
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

    @Column(nullable = false, length = 50)
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

}
