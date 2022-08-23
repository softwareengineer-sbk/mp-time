package com.app.self.exception;

import lombok.Getter;

@Getter
public class MosqueTimeNotFoundException extends Exception{
    private String message;

    public MosqueTimeNotFoundException(String message) {
        this.message = message;
    }
}
