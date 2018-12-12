package com.isa.cm3.filters;

import com.isa.cm3.servlets.DelegationSearchServlet;
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

    private static final Logger LOG = LogManager.getLogger(DelegationSearchServlet.class);

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        LOG.info("AuthenticationFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        Session(request, response, chain, req, res, uri);
    }

    private void Session(ServletRequest request, ServletResponse response, FilterChain chain, HttpServletRequest req, HttpServletResponse res, String uri) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        if(session == null && !(uri.endsWith("/delegations-web/") || uri.endsWith("/login") || uri.endsWith("/sign-in"))){
            res.sendRedirect("/delegations-web/");
        }else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}
