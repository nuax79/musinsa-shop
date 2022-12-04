package com.musinsa.shop.common.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musinsa.shop.common.BucketLimiter;
import com.musinsa.shop.common.exception.ThrottleException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class ApiRateLimiterInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            BucketLimiter.decrease();
            log.info("Forwarding the request..");
            return true;
        } catch (ThrottleException e) {
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json");
            response.setStatus(429); // Too many requests
            response.getWriter().write(mapper.writeValueAsString("Request Throttled."));
            log.info("Request Throttled.");
            return false;
        }
    }
}