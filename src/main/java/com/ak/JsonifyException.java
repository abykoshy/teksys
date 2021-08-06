package com.ak;

import java.io.IOException;

public class JsonifyException extends SearchServiceException {
    public JsonifyException(IOException e) {
        super(e);
    }
}
