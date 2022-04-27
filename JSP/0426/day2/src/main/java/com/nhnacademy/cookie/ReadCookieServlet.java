package com.nhnacademy.cookie;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "readCookieServlet", urlPatterns = "/read-cookie")
public class ReadCookieServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        Cookie cookie = Arrays.stream(cookies)
            .filter(e -> "locale".equals(e.getName()))
            .findFirst()
            .orElse(null);

        if(Objects.isNull(cookie)) {
            resp.sendError(500, "cookie not found");
            return;
        }

        String locale = cookie.getValue();

        String helloValue = ResourceBundle.getBundle("message", new Locale(locale))
                                          .getString("hello");

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println(helloValue);
    }
}
