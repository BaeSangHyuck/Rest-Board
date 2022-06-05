package com.callbus.exception;

public class UserNotFoundException extends RuntimeException{

    public static final String MESSAGE = "회원이 아닙니다. 로그인을 진행해주세요.";

    public UserNotFoundException() {
        super(MESSAGE);
    }
}
