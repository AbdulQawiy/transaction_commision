package com.solution.test.exception;

/**
 * Created by Taiwo.Adio on 8/11/2015.
 */
public class AbstractException extends RuntimeException {
    String code;

    public AbstractException(String code, String message){
        super(message);
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
}
