package com.isa.cm3.servlets;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            resp.setHeader("Content-Type", "text/html; charset=utf-8");
            resp.setContentType("text/html;charset=UTF-8 pageEncoding=\"UTF-8");

            try {
                HttpSession session = req.getSession();
                session.invalidate();
                resp.sendRedirect("/delegations-web/");
                req.getServletContext()
                        .getRequestDispatcher("mainMenu").forward(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

