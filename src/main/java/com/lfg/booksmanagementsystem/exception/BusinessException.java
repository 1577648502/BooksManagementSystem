package com.lfg.booksmanagementsystem.exception;


import com.lfg.booksmanagementsystem.utils.ErrorCode;

import java.io.Serial;

/**
 * @Description: 自定义异常类
 */
public class BusinessException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 2942420535500634982L; //序列化ID
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
