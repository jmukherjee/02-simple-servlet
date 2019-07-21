package com.adsk.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class ServletB  extends GenericServlet {

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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("POST Called from generic servlet (ServletB)");
        out.println("Param:" + request.getParameter("name"));
        out.println("Contentlength:" + request.getContentLength() );
        out.println(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h3>hello from generic servlet (ServletB)</h3>");
    }
}
