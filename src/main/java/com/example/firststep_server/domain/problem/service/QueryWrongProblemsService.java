package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.repository.UserIncorrectAnswerRepository;
import com.example.firststep_server.domain.problem.presentation.dto.response.WrongProblemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryWrongProblemsService {
    private final UserIncorrectAnswerRepository userIncorrectAnswerRepository;

    public List<WrongProblemResponse> queryWrongProblems() {
        return userIncorrectAnswerRepository.findAll()
                .stream()
                .map(wrongProblemResponses -> new WrongProblemResponse(wrongProblemResponses))
                .collect(Collectors.toList());
    }
}
