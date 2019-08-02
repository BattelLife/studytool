package com.studydesign.studytoolweb.handle.resultHandler;



public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }

    public static Result error(Integer code, String msg) {
        if(code == 200){
            code = 500;
        }
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(Integer code, String msg, Object o) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(o);
        return result;
    }
}

