package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProblemService {
    private final ProblemRepository problemRepository;

    public void deleteProblem(Long id){
        problemRepository.deleteById(id);
    }
}
