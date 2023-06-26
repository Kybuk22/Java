package edu.technischools.java.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.technischools.java.model.Equation;
import edu.technischools.java.service.Calculator;
import edu.technischools.java.service.ComputationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

public class CalculatorServlet extends HttpServlet {
    private final Calculator calculator;
    private final ObjectMapper objectMapper;

    public CalculatorServlet() {
        calculator = Calculator.getInstance();
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String operation = uri.substring(uri.lastIndexOf('/') + 1).toUpperCase();

        try {
            Double operandA = Double.parseDouble(request.getParameter("operandA"));
            Double operandB = Double.parseDouble(request.getParameter("operandB"));

            Double result = calculator.compute(operandA, operandB, operation);
            response.getWriter().write(String.valueOf(result));
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Błędne parametry.");
        } catch (ComputationException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Equation equation = objectMapper.readValue(request.getReader(), Equation.class);
        String operation = getOperationFromURI(request.getRequestURI()).toUpperCase();

        try {
            Double result = calculator.compute(equation.getOperandA(), equation.getOperandB(), operation);

            equation.setResult(result);
            equation.setError(null);

            String jsonResponse = objectMapper.writeValueAsString(equation);
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);
        } catch (ComputationException e) {
            equation.setResult(null);
            equation.setError(e.getMessage());

            String jsonResponse = objectMapper.writeValueAsString(equation);
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(jsonResponse);
        }
    }

    private String getOperationFromURI(String uri) {
        return uri.substring(uri.lastIndexOf('/') + 1);
    }
}
