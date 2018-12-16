package com.isa.cm3.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    private static final Logger LOG = LogManager.getLogger(AuthenticationFilter.class);

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        LOG.info("AuthenticationFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        LOG.debug("Requested uri= " + uri);
        LOG.debug("Sprawdzenie czy zalogowany ");
        valdiateSession(request, response, chain, req, res, uri);

    }

    private void valdiateSession(ServletRequest request, ServletResponse response, FilterChain chain, HttpServletRequest req, HttpServletResponse res, String uri) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        if (isSessionValid(session, uri)) {
            res.sendRedirect("/delegations-web/");
            LOG.debug("Przekierowanie bo niezalogowany");
        } else {
            chain.doFilter(request, response);
            LOG.debug("zalogowany");
        }
    }

    private boolean isSessionValid(HttpSession session, String uri) {
        return session == null && !(uri.endsWith("/delegations-web/") || uri.endsWith("/login") || uri.endsWith("/sign-in") || uri.endsWith("/resources"));
    }

    public void destroy() {
    }
}
