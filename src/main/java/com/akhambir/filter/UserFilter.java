package com.akhambir.filter;

import com.akhambir.dao.UserDao;
import com.akhambir.factory.Factory;
import com.akhambir.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserFilter implements Filter {

    private UserDao userDao;
    private final String TOKEN = "TOKEN";
    private List<String> protectedUrl = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userDao = Factory.getUserDao();
        protectedUrl.add("/root/profile");
//        protectedUrl.add("/admin"); TO DO HOMEWORK
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Cookie[] cookies = httpRequest.getCookies();
        String uri = httpRequest.getRequestURI();

        if (protectedUrl.contains(uri)) {
            String token = null;
            for (Cookie cookie : cookies) {
                String name = cookie.getName().toUpperCase();
                if (TOKEN.equals(name)) {
                    token = cookie.getValue();
                    User user = userDao.findByToken(token);
                    request.setAttribute("userId", String.valueOf(user.getUserId()));
                }
            }
            if (token == null) {
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
