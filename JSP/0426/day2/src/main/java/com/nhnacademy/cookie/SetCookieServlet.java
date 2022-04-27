package com.nhnacademy.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "setCookieServlet", urlPatterns = "/set-cookie")
public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String locale = req.getParameter("locale");
        Cookie cookie = new Cookie("locale", locale);
        cookie.setPath("/");
        resp.addCookie(cookie);

        resp.getWriter().println("OK");
    }
}
