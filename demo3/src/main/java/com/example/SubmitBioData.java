package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SubmitBioData")
public class SubmitBioData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String bio = request.getParameter("bio");

        // Set response content type
        response.setContentType("text/html");

        // Get PrintWriter to write response
        PrintWriter out = response.getWriter();

        // Write HTML response
        out.println("<html>");
        out.println("<head><title>Submitted Bio Data</title></head>");
        out.println("<body>");
        out.println("<h1>Submitted Bio Data</h1>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Age:</strong> " + age + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Bio:</strong> " + bio.replace("\n", "<br>") + "</p>");
        out.println("<a href='App.jsp'>Submit Another</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
