package com.example.firststep_server.infrastructure.s3.exception;

import com.example.firststep_server.global.error.exception.ErrorCode;
import com.example.firststep_server.global.error.exception.TurkeyException;

public class ImageNotFoundException extends TurkeyException {
    public static final TurkeyException EXCEPTION = new ImageNotFoundException();

    public ImageNotFoundException() {
        super(ErrorCode.IMAGE_NOT_FOUND);
    }
}
