package com.techpower.pitchweb.exception;

public class PitchException extends BaseException {
    public PitchException() {
    }

    public PitchException(String errorCode, String message) {
        super(errorCode);
        setMessage(message);
    }

    public PitchException(String errorCode, String message, String logDetail) {
        super(errorCode);
        setMessage(message);
    }
}
