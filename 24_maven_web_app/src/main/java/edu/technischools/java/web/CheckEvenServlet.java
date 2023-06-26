package edu.technischools.java.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkEven")
public class CheckEvenServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numberParam = request.getParameter("number");
        int number = Integer.parseInt(numberParam);
        boolean isEven = number % 2 == 0;

        response.setContentType("text/plain");
        response.getWriter().println(isEven);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numberParam = request.getParameter("number");
        int number = Integer.parseInt(numberParam);
        boolean isEven = number % 2 == 0;

        response.setContentType("text/plain");
        response.getWriter().println(isEven);
    }
}
