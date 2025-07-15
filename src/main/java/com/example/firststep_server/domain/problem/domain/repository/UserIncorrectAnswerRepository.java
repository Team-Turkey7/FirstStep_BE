package com.example.firststep_server.domain.problem.domain.repository;

import com.example.firststep_server.domain.problem.domain.UserIncorrectAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIncorrectAnswerRepository extends JpaRepository<UserIncorrectAnswer,Long> {

}
