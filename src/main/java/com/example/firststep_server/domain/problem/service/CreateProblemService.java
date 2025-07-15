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

    public void excute(CreateProblemRequest createProblemRequest) {
        problemRepository.save(
                Problem.builder()
                        .category(createProblemRequest.getCategory())
                        .date(createProblemRequest.getDate())
                        .problem(createProblemRequest.getProblem())
                        .problemDetail(createProblemRequest.getProblemDetail())
                        .photoUrl(createProblemRequest.getPhotoUrl())
                        .build()
        );
    }
}