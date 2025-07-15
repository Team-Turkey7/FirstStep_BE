package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.Problem;
import com.example.firststep_server.domain.problem.domain.repository.ProblemRepository;
import com.example.firststep_server.domain.problem.presentation.dto.request.CreateProblemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProblemService {
    private final ProblemRepository problemRepository;

    public void execute(CreateProblemRequest createProblemRequest) {
        System.out.println(createProblemRequest.getPhotoUrl());
        System.out.println(createProblemRequest.getAudioUrl());

        problemRepository.save(
                Problem.builder()
                        .category(createProblemRequest.getCategory())
                        .date(createProblemRequest.getDate())
                        .problem(createProblemRequest.getProblem())
                        .problemDetail(createProblemRequest.getProblemDetail())
                        .answer(createProblemRequest.getAnswer())
                        .photoUrl(createProblemRequest.getPhotoUrl())
                        .audioUrl(createProblemRequest.getAudioUrl())
                        .level(createProblemRequest.getLevel())
                        .build()
        );
    }
}