package com.example.firststep_server.infrastructure.s3.exception;

import com.example.firststep_server.global.error.exception.ErrorCode;
import com.example.firststep_server.global.error.exception.TurkeyException;

public class FailedUploadException extends TurkeyException {
    public static final TurkeyException EXCEPTION = new FailedUploadException();

    private FailedUploadException() {
        super(ErrorCode.FAILED_UPLOAD);
    }
}
