package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.Problem;
import com.example.firststep_server.domain.problem.domain.repository.ProblemRepository;
import com.example.firststep_server.domain.problem.exception.ProblemNotFoundException;
import com.example.firststep_server.infrastructure.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteProblemService {
    private final ProblemRepository problemRepository;
    private final S3Service s3Service;

    @Transactional
    public void deleteProblem(Long id) {
        Problem problem = problemRepository.findById(id)
                        .orElseThrow(() -> ProblemNotFoundException.EXCEPTION);

        s3Service.delete(problem.getPhotoUrl());

        problemRepository.delete(problem);
    }
}
