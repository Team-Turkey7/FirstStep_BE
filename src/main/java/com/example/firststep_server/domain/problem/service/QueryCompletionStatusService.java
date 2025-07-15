package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.Completion;
import com.example.firststep_server.domain.problem.domain.repository.CompletionRepository;
import com.example.firststep_server.domain.problem.exception.CompletionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryCompletionStatusService {
    private final CompletionRepository completionRepository;

    public boolean execute(String date) {
        Completion completion = completionRepository.findByDate(date)
                .orElseThrow(() -> CompletionNotFoundException.EXCEPTION);

        return completion.isComplete();
    }
}
