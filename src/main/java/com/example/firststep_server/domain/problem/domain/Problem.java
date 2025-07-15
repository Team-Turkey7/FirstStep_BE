package com.example.firststep_server.domain.problem.domain;

import com.example.firststep_server.domain.problem.domain.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false, length = 50)
    private String problemName;

    @Column(length = 10)
    private String problemDetail;

    @Column(nullable = false, length = 10)
    private String answer;

    @Column(nullable = false)
    private boolean result;

    private String photoUrl;

    private String audioUrl;
}
