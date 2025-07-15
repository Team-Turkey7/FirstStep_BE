package com.example.firststep_server.domain.problem.exception;

import com.example.firststep_server.global.error.exception.ErrorCode;
import com.example.firststep_server.global.error.exception.TurkeyException;

public class CompletionNotFoundException extends TurkeyException {
    public static final TurkeyException EXCEPTION = new CompletionNotFoundException();

    private CompletionNotFoundException() {
        super(ErrorCode.COMPLETION_NOT_FOUND);
    }
}
