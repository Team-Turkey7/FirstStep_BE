package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.repository.ProblemRepository;
import com.example.firststep_server.domain.problem.presentation.dto.request.ProblemRequest;
import com.example.firststep_server.domain.problem.presentation.dto.response.ProblemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryProblemByCategoryAndDateService {
    private final ProblemRepository problemRepository;

    public List<ProblemResponse> execute(ProblemRequest request) {
        return problemRepository.findByCategoryAndDateOrderByIdAsc(request.getCategory(), request.getDate());
    }
}
