package com.example.firststep_server.domain.problem.domain.repository;

import com.example.firststep_server.domain.problem.domain.Completion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompletionRepository extends JpaRepository<Completion, Long> {
    Optional<Completion> findByDate(String date);
}
