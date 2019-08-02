package com.studydesign.studytoolweb.handle.resultHandler;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String msg;
    private Object data;
}
