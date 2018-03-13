package org.spring.web.web5.controller;




import org.spring.web.web5.model.Role;
import org.spring.web.web5.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter({"/admin/*", "/user"})
public class RoleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/index.jsp";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean admin = false;
        User user = (User) session.getAttribute("user");
        if (loggedIn || loginRequest) {
            for (Role role : user.getRoles()) {
                if (role.getRole().equalsIgnoreCase("admin")) {
                    admin = true;
                }
            }
            if (admin) {
                filterChain.doFilter(request, response); // User is logged in as admin, just continue request.
            } else {
                filterChain.doFilter(request, response); // User is logged in as user, redirect to user page
                response.sendRedirect("/user");
            }
        } else {
            response.sendRedirect("/"); // Not logged in, show login page.
        }

    }

    @Override
    public void destroy() {

    }
}
