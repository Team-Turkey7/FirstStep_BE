package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.Completion;
import com.example.firststep_server.domain.problem.domain.repository.CompletionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryAllCompletionStatusService {
    private final CompletionRepository completionRepository;

    public List<Completion> execute() {
        return completionRepository.findAll();
    }
}
