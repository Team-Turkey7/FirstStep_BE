package com.example.firststep_server.domain.problem.presentation;

import com.example.firststep_server.domain.problem.presentation.dto.request.JudgementProblemRequest;
import com.example.firststep_server.domain.problem.presentation.dto.response.ProblemResponse;
import com.example.firststep_server.domain.problem.service.JudgeProblemService;
import com.example.firststep_server.domain.problem.service.QueryProblemsByDateService;
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
    private final JudgeProblemService judgeProblemService;

    @GetMapping("/{date}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProblemResponse> queryProblemByDate(@PathVariable String date) {
        return queryProblemsByDateService.execute(date);
    }

    @GetMapping("/judge")
    @ResponseStatus(HttpStatus.OK)
    public boolean judgeProblem(@RequestBody @Valid JudgementProblemRequest request) {
        return judgeProblemService.execute(request);
    }
}
