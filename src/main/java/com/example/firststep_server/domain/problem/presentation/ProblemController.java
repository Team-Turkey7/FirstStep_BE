package com.example.firststep_server.domain.problem.presentation;

import com.example.firststep_server.domain.problem.domain.Completion;
import com.example.firststep_server.domain.problem.presentation.dto.request.CreateProblemRequest;
import com.example.firststep_server.domain.problem.presentation.dto.request.JudgementProblemRequest;
import com.example.firststep_server.domain.problem.presentation.dto.request.UpdateProblemRequest;
import com.example.firststep_server.domain.problem.presentation.dto.response.ProblemResponse;
import com.example.firststep_server.domain.problem.presentation.dto.response.WrongProblemResponse;
import com.example.firststep_server.domain.problem.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/problem")
@RequiredArgsConstructor
public class ProblemController {
    private final QueryProblemsByDateService queryProblemsByDateService;
    private final CreateProblemService createProblemService;
    private final UpdateProblemService updateProblemService;
    private final DeleteProblemService deleteProblemService;
    private final QueryCompletionStatusService queryCompletionStatusService;
    private final JudgeProblemService judgeProblemService;
    private final QueryWrongProblemsService queryWrongProblemsService;
    private final QueryAllCompletionStatusService queryAllCompletionStatusService;

    @PostMapping
    public void createProblem(@RequestPart(name = "request") CreateProblemRequest request,
                              @RequestPart(name = "audio") MultipartFile audio,
                              @RequestPart(name = "image") MultipartFile image) {
        createProblemService.createProblem(audio, image, request);
    }

    @GetMapping("/{date}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProblemResponse> queryProblemByDate(@PathVariable String date) {
        return queryProblemsByDateService.execute(date);
    }

    @GetMapping("/completion/{date}")
    @ResponseStatus(HttpStatus.OK)
    public boolean queryProblemStatus(@PathVariable String date) {
        return queryCompletionStatusService.execute(date);
    }

    @GetMapping("/mypage")
    @ResponseStatus(HttpStatus.OK)
    public List<WrongProblemResponse> queryWrongProblems() {
        return queryWrongProblemsService.queryWrongProblems();
    }

    @GetMapping("/completion")
    @ResponseStatus(HttpStatus.OK)
    public List<Completion> queryCompletions() {
        return queryAllCompletionStatusService.execute();
    }

    @PostMapping("/judge")
    @ResponseStatus(HttpStatus.OK)
    public boolean judge(@RequestBody @Valid JudgementProblemRequest request) {
        return judgeProblemService.execute(request);
    }

    @PatchMapping("/{id}")
    public void updateProblem(@PathVariable Long id, @RequestBody UpdateProblemRequest request) {
        updateProblemService.updateProblem(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteProblem(@PathVariable Long id) {
        deleteProblemService.deleteProblem(id);
    }
}
