package com.nhnacademy.cookie;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpSessionListenerTest implements HttpSessionListener {
    private int sessionCount = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionCount++;
        log.error("session count={}", sessionCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionCount--;
        log.error("session count={}", sessionCount);
    }
}
