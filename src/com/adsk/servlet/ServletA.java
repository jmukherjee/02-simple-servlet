package com.adsk.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class ServletA implements Servlet {

    ServletConfig config=null;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config=config;
        System.out.println("servlet is initialized");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp; ;
        if(request.getMethod().equals("GET")) {
            doGet(request, response);
        } else if(request.getMethod().equals("POST")) {
            doPost(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "copyright 2000-2020";
    }

    @Override
    public void destroy() {
        System.out.println("servlet is destroyed");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("POST Called from simple servlet (ServletA)");
        out.println("Param:" + request.getParameter("name"));
        out.println("Contentlength:" + request.getContentLength() );
        out.println(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h3>hello from simple servlet (ServletA)</h3>");
    }
}
