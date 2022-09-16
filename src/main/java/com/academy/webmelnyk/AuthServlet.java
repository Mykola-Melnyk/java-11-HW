package com.academy.webmelnyk;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "authServlet", value = "/login")
public class AuthServlet extends HttpServlet {
    private String login;
    private String password;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(true);
        session.setAttribute("login", request.getParameter("login"));
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1></h1>");
        out.println("</body></html>");
    }

}