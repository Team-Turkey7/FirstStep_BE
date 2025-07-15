package com.example.firststep_server.domain.problem.presentation;

import com.example.firststep_server.domain.problem.presentation.dto.request.CreateProblemRequest;
import com.example.firststep_server.domain.problem.presentation.dto.response.ProblemResponse;
import com.example.firststep_server.domain.problem.service.CreateProblemService;
import com.example.firststep_server.domain.problem.service.QueryProblemsByDateService;
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

    @GetMapping("/{date}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProblemResponse> queryProblemByDate(@PathVariable String date) {
        return queryProblemsByDateService.execute(date);
    }

    @PostMapping
    public void createProblem(@RequestBody CreateProblemRequest request) {
        createProblemService.createProblem(request);
    }
}
