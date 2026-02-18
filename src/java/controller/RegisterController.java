package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import service.AuthService;
import service.impl.AuthServiceImpl;

import java.io.IOException;

public class RegisterController extends HttpServlet {

    private final AuthService authService = new AuthServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        authService.register(username, password);

        response.sendRedirect(request.getContextPath() + "/login.jsp?registered=true");
    }
}
