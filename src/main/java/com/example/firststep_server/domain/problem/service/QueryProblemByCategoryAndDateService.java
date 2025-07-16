package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.Completion;
import com.example.firststep_server.domain.problem.domain.repository.CompletionRepository;
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
    private final CompletionRepository completionRepository;

    public List<ProblemResponse> execute(ProblemRequest request) {

        Completion completion = completionRepository.findByDate(request.getDate())
                .orElseThrow();

        completion.complete();

        return problemRepository.findByCategoryAndDateOrderByIdAsc(request.getCategory(), request.getDate());
    }
}
