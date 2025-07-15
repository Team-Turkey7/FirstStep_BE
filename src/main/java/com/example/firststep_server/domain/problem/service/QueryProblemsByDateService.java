package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.Completion;
import com.example.firststep_server.domain.problem.domain.repository.CompletionRepository;
import com.example.firststep_server.domain.problem.domain.repository.ProblemRepository;
import com.example.firststep_server.domain.problem.exception.CompletionNotFoundException;
import com.example.firststep_server.domain.problem.presentation.dto.response.ProblemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryProblemsByDateService {
    private final ProblemRepository problemRepository;
    private final CompletionRepository completionRepository;

    @Transactional
    public List<ProblemResponse> execute(String date) {

        Completion completion = completionRepository.findByDate(date)
                .orElseThrow(() -> CompletionNotFoundException.EXCEPTION);

        completion.complete();

        return problemRepository.findByDateOrderByIdAsc(date);
    }
}
