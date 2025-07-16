package com.example.firststep_server.domain.problem.domain.repository;

import com.example.firststep_server.domain.problem.domain.Problem;
import com.example.firststep_server.domain.problem.domain.enums.Category;
import com.example.firststep_server.domain.problem.presentation.dto.response.ProblemResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemRepository extends CrudRepository<Problem, Long> {
    List<ProblemResponse> findByDateOrderByIdAsc(String date);

    List<ProblemResponse> findByCategoryAndDateOrderByIdAsc(Category category, String date);
}
