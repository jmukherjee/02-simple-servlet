package com.adsk.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

//@WebServlet(name = "servlet-c")
public class ServletC extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("POST Called from httpservlet (ServletC)");
        out.println("Param:" + request.getParameter("name"));
        out.println("Contentlength:" + request.getContentLength() );
        out.println(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>hello from httpservlet (ServletC)</h3>");
    }
}
