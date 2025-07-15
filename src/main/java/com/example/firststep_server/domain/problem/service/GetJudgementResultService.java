package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.UserIncorrectAnswer;
import com.example.firststep_server.domain.problem.domain.repository.ProblemRepository;
import com.example.firststep_server.domain.problem.domain.repository.UserIncorrectAnswerRepository;
import com.example.firststep_server.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetJudgementResultService {
    private final ProblemRepository problemRepository;
    private final UserIncorrectAnswerRepository userIncorrectAnswerRepository;
}
