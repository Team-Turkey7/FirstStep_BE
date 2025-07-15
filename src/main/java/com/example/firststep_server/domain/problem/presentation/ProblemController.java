package com.example.firststep_server.domain.problem.presentation;

import com.example.firststep_server.domain.problem.presentation.dto.request.CreateProblemRequest;
import com.example.firststep_server.domain.problem.presentation.dto.request.JudgementProblemRequest;
import com.example.firststep_server.domain.problem.presentation.dto.request.UpdateProblemRequest;
import com.example.firststep_server.domain.problem.presentation.dto.response.ProblemResponse;
import com.example.firststep_server.domain.problem.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void createProblem(@RequestBody CreateProblemRequest request) {
        createProblemService.createProblem(request);
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

    @GetMapping("/judge")
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
