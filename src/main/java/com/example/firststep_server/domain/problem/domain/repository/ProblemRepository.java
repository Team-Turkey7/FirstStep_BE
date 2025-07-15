package com.example.firststep_server.domain.problem.domain.repository;

import com.example.firststep_server.domain.problem.domain.Problem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemRepository extends CrudRepository<Problem, Long> {
}
