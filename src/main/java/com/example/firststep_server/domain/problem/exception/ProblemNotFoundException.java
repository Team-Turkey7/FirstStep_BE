package com.example.firststep_server.domain.problem.exception;

import com.example.firststep_server.global.error.exception.ErrorCode;
import com.example.firststep_server.global.error.exception.TurkeyException;

public class ProblemNotFoundException extends TurkeyException {
    public static final TurkeyException EXCEPTION = new ProblemNotFoundException();

    private ProblemNotFoundException() {
        super(ErrorCode.PROBLEM_NOT_FOUND);
    }

}
