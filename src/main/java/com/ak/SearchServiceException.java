package com.ak;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchServiceException extends Throwable{

    public SearchServiceException(Exception e) {
        log.error(e.getMessage(), e);
    }
}
