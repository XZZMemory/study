package com.memory.study.framework.exception;

import com.memory.study.constant.ErrorCode;

/**
 * created by memory
 * on 2019/8/28 10 10
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final int code;
    private final String messageKey;
    private final String overrideMessage;

    public ServiceException(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMsg());
    }

    ServiceException(int code, String overrideMessage) {
        this.code = code;
        this.overrideMessage = overrideMessage;
        this.messageKey = null;
    }
}
