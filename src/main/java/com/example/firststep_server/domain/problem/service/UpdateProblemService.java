package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.Problem;
import com.example.firststep_server.domain.problem.domain.repository.ProblemRepository;
import com.example.firststep_server.domain.problem.exception.ProblemNotFoundException;
import com.example.firststep_server.domain.problem.presentation.dto.request.UpdateProblemRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProblemService {
    private final ProblemRepository problemRepository;

    @Transactional
    public void updateProblem(Long id, UpdateProblemRequest updateProblemRequest) {
        Problem problem = problemRepository.findById(id).orElseThrow(() -> ProblemNotFoundException.EXCEPTION);
        problem.updateProblem(updateProblemRequest);
    }
}