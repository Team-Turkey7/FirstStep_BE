package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.repository.ProblemRepository;
import com.example.firststep_server.domain.problem.presentation.dto.response.ProblemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryProblemsByDateService {
    private final ProblemRepository problemRepository;

    @Transactional(readOnly = true)
    public List<ProblemResponse> execute(String date) {
        return problemRepository.findByDate(date);
    }
}
