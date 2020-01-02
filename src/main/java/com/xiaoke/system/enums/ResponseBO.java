package com.xiaoke.system.enums;

public class ResponseBO {
    private Integer code;
    private String message;

    public ResponseBO(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
