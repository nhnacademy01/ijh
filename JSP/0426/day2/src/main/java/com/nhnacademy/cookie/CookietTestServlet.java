package com.nhnacademy.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name = "cookieTestServlet", urlPatterns = "/cookie-test/*")
@Slf4j
public class CookietTestServlet extends HttpServlet {
    private static final String COOKIE_NAME = "cook2";
    private static final String MORE_PATH = "/cookie-test/more/write";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
            String requestUri = req.getRequestURI();

            // TODO : Util class로 만들자.
            int count = (int) getServletContext().getAttribute("counter");
            count++;
            getServletContext().setAttribute("count", count);

            if (requestUri.endsWith("/read")) {
                readCookie(req, resp);
            } else if(requestUri.endsWith("/write")) {
                writeCookie(req, resp);
            } else {
                show(req, resp);
            }
    }

    private void writeCookie(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String domain = req.getParameter("domain");
        String path = MORE_PATH.equals(req.getRequestURI()) ? "/cookie-test/more/write" : "/";

        Cookie newCookie = new Cookie(COOKIE_NAME, req.getRequestURL().append("?").append(req.getQueryString()).toString());
        newCookie.setDomain(domain);
        newCookie.setPath(path);

        resp.addCookie(newCookie);
        show(req, resp);
    }

    public static Cookie getCookie(HttpServletRequest req, String name) {
        return Optional.ofNullable(req.getCookies())
            .flatMap(cookies -> Arrays.stream(cookies)
                .filter(c -> c.getName().equals(name))
                .findFirst())
            .orElse(null);
    }

    private void readCookie(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        Cookie cookie = getCookie(req, COOKIE_NAME);
        String cookieValue = Optional.ofNullable(cookie).map(Cookie::getValue).orElse(null);

        resp.setContentType("text/plain");
        resp.getWriter().println("cookie value=" + cookieValue);
    }

    private void show(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>cookie test</title></head>");
        out.println("<body>");

        out.println("<a href='http://a.com:8080/cookie-test/write?domain=a.com'>set cookie: domain=a.com, path=/</a><br />");
        out.println("<a href='http://a.com:8080/cookie-test/write?domain=.a.com'>set cookie: domain=.a.com, path=/</a><br />");
        out.println("<a href='http://1.a.com:8080/cookie-test/write?domain=.1.a.com'>set cookie: domain=.1.a.com, path=/</a><br />");
        out.println("<a href='http://1.a.com:8080/cookie-test/more/write?domain=.a.com'>set cookie: domain=.a.com, path=/cookie-test/more</a><br />");
        out.println("<br />");

        out.println("<a href='http://a.com:8080/cookie-test/read'>get cookie: domain=a.com</a><br />");
        out.println("<a href='http://b.com:8080/cookie-test/read'>get cookie: domain=b.com</a><br />");
        out.println("<a href='http://1.a.com:8080/cookie-test/read'>get cookie: domain=1.a.com</a><br />");
        out.println("<a href='http://2.a.com:8080/cookie-test/read'>get cookie: domain=2.a.com</a><br />");
        out.println("<a href='http://1.a.com:8080/cookie-test/more/read'>get cookie: domain=1.a.com, path=/cookie-test/more/read</a><br />");

        out.println("</body>");
        out.println("</html>");
    }
}
