package com.example.firststep_server.domain.problem.presentation;

import com.example.firststep_server.domain.problem.presentation.dto.request.CreateProblemRequest;
import com.example.firststep_server.domain.problem.presentation.dto.request.UpdateProblemRequest;
import com.example.firststep_server.domain.problem.presentation.dto.response.ProblemResponse;
import com.example.firststep_server.domain.problem.service.CreateProblemService;
import com.example.firststep_server.domain.problem.service.QueryProblemsByDateService;
import com.example.firststep_server.domain.problem.service.UpdateProblemService;
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

    @GetMapping("/{date}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProblemResponse> queryProblemByDate(@PathVariable String date) {
        return queryProblemsByDateService.execute(date);
    }

    @PostMapping
    public void createProblem(@RequestBody CreateProblemRequest request) {
        createProblemService.createProblem(request);
    }

    @PatchMapping("/{id}")
    public  void updateProblem(@PathVariable Long id, @RequestBody UpdateProblemRequest request) {
        updateProblemService.updateProblem(id, request);
    }
}
