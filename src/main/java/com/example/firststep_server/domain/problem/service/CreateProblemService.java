package com.example.firststep_server.domain.problem.service;

import com.example.firststep_server.domain.problem.domain.Completion;
import com.example.firststep_server.domain.problem.domain.Problem;
import com.example.firststep_server.domain.problem.domain.repository.CompletionRepository;
import com.example.firststep_server.domain.problem.domain.repository.ProblemRepository;
import com.example.firststep_server.domain.problem.presentation.dto.request.CreateProblemRequest;
import com.example.firststep_server.infrastructure.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateProblemService {
    private final ProblemRepository problemRepository;
    private final CompletionRepository completionRepository;
    private final S3Service s3Service;

    @Transactional
    public void createProblem(MultipartFile image, CreateProblemRequest createProblemRequest) {

        String photoUrl = s3Service.upload(image);

        problemRepository.save(
                Problem.builder()
                        .category(createProblemRequest.getCategory())
                        .date(createProblemRequest.getDate())
                        .problem(createProblemRequest.getProblem())
                        .problemDetail(createProblemRequest.getProblemDetail())
                        .photoUrl(photoUrl)
                        .answer(createProblemRequest.getAnswer())
                        .level(createProblemRequest.getLevel())
                        .isCorrect(false)
                        .build()
        );

        List<Completion> found = completionRepository.findAllByDate(createProblemRequest.getDate());

        if (found.isEmpty()) {
            completionRepository.save(
                    Completion.builder()
                            .date(createProblemRequest.getDate())
                            .isComplete(false)
                            .build()
            );
        }

    }
}