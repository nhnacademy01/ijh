package com.nhnacademy.cookie;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

// 쿠키 2번째 ,세션 안됨
@Slf4j
public class LoginServlet extends HttpServlet {
    private String configId;
    private String configPwd;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        configId = config.getInitParameter("id");
        configPwd = config.getInitParameter("pwd");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(Objects.isNull(session)) {
            RequestDispatcher rd = req.getRequestDispatcher("/login.html");
            rd.forward(req, resp);
        } else {
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");

            resp.getWriter().println("Login Success: " + session.getAttribute("id"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        if (configId.equals(id) && configPwd.equals(pwd)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("id", id);

            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("/login.html");
        }
    }
}
