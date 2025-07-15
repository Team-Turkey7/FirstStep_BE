package com.example.firststep_server.infrastructure.s3.exception;

import com.example.firststep_server.global.error.exception.ErrorCode;
import com.example.firststep_server.global.error.exception.TurkeyException;

public class FailedDeleteException extends TurkeyException {
    public static final TurkeyException EXCEPTION = new FailedDeleteException();

    private FailedDeleteException() {
        super(ErrorCode.FAILED_DELETE);
    }
}
