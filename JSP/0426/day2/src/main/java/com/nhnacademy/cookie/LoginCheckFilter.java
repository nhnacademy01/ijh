package com.nhnacademy.cookie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
    List<String> urls = Arrays.asList("/login", "/login.html", "logout", "loginForm");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String blackList = filterConfig.getInitParameter("blackList");
        String[] arr = blackList.split("\n");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        String requsetUri = ((HttpServletRequest) servletRequest).getRequestURI();

        // black List
        // white List
        if(urls.contains(requsetUri)) {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
            if(Objects.isNull(session)) {
                RequestDispatcher rd = servletRequest.getRequestDispatcher("/loginForm");
                rd.forward(servletRequest, servletResponse);
//                ((HttpServletResponse) servletResponse).sendRedirect("/login.html");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
