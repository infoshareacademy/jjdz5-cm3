package com.isa.cm3.servlets;



import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@WebServlet(urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            HttpSession session = req.getSession();
            try {
                String token = (String) session.getAttribute("token");
                String urlString = String.format(
                        "https://accounts.google.com/o/oauth2/revoke?token=%s", token);
                URL url = new URL(urlString);
                URLConnection conn = url.openConnection();
                InputStream is = conn.getInputStream();
                is.close();
            } catch (Exception e) {
            }

            try {
                session.invalidate();
                resp.sendRedirect("/delegations-web/");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

