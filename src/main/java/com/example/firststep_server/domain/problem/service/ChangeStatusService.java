package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.Completion;
import com.example.firststep_server.domain.problem.domain.repository.CompletionRepository;
import com.example.firststep_server.domain.problem.exception.CompletionNotFoundException;
import com.example.firststep_server.domain.problem.presentation.dto.request.ChangeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChangeStatusService {
    private final CompletionRepository completionRepository;

    @Transactional
    public void execute(ChangeRequest request) {
        Completion completion = completionRepository.findByDate(request.getDate())
                .orElseThrow(() -> CompletionNotFoundException.EXCEPTION);

        completion.change();
    }
}
