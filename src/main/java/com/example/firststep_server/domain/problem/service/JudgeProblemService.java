package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.Problem;
import com.example.firststep_server.domain.problem.domain.UserIncorrectAnswer;
import com.example.firststep_server.domain.problem.domain.repository.ProblemRepository;
import com.example.firststep_server.domain.problem.domain.repository.UserIncorrectAnswerRepository;
import com.example.firststep_server.domain.problem.exception.ProblemNotFoundException;
import com.example.firststep_server.domain.problem.presentation.dto.request.JudgementProblemRequest;
import com.example.firststep_server.domain.user.domain.User;
import com.example.firststep_server.domain.user.service.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JudgeProblemService {
    private final ProblemRepository problemRepository;
    private final UserIncorrectAnswerRepository userIncorrectAnswerRepository;

    public boolean execute(JudgementProblemRequest request) {

        Problem problem = problemRepository.findById(request.getId())
                .orElseThrow(() -> ProblemNotFoundException.EXCEPTION);

        if (!problem.getAnswer().equals(request.getUserAnswer())) {
            userIncorrectAnswerRepository.save(UserIncorrectAnswer.builder()
                            .problem(problem.getProblem())
                            .category(problem.getCategory())
                            .photoUrl(problem.getPhotoUrl())
                            .problemDetail(problem.getProblemDetail())
                            .answer(problem.getAnswer())
                            .date(problem.getDate())
                    .build());

            problem.markAsCorrect();
            problemRepository.save(problem);
        }

        return problem.isCorrect();
    }
}
