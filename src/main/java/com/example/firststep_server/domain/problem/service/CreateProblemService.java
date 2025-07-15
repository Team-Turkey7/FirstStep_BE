package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.Completion;
import com.example.firststep_server.domain.problem.domain.Problem;
import com.example.firststep_server.domain.problem.domain.repository.CompletionRepository;
import com.example.firststep_server.domain.problem.domain.repository.ProblemRepository;
import com.example.firststep_server.domain.problem.presentation.dto.request.CreateProblemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProblemService {
    private final ProblemRepository problemRepository;
    private final CompletionRepository completionRepository;

    public void createProblem(CreateProblemRequest createProblemRequest) {
        problemRepository.save(
                Problem.builder()
                        .category(createProblemRequest.getCategory())
                        .date(createProblemRequest.getDate())
                        .problem(createProblemRequest.getProblem())
                        .problemDetail(createProblemRequest.getProblemDetail())
                        .photoUrl(createProblemRequest.getPhotoUrl())
                        .answer(createProblemRequest.getAnswer())
                        .audioUrl(createProblemRequest.getAudioUrl())
                        .level(createProblemRequest.getLevel())
                        .isCorrect(false)
                        .build()
        );

        completionRepository.save(
                Completion.builder()
                        .date(createProblemRequest.getDate())
                        .isComplete(false)
                        .build()
        );
    }
}