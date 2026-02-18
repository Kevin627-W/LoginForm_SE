package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import model.LoginAudit;
import model.User;
import service.AuthService;
import service.impl.AuthServiceImpl;
import repository.LoginAuditRepository;
import repository.impl.LoginAuditRepositoryImpl;

import java.io.IOException;

public class LoginController extends HttpServlet {

    private final AuthService authService = new AuthServiceImpl();
    private final LoginAuditRepository auditRepo = new LoginAuditRepositoryImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = authService.login(username, password);
        boolean success = (user != null);

        // ====== SAVE LOGIN AUDIT ======
        LoginAudit audit = new LoginAudit();
        audit.setUsername(username);
        audit.setIpAddress(request.getRemoteAddr());
        audit.setUserAgent(request.getHeader("User-Agent"));

        String ua = request.getHeader("User-Agent");
        audit.setDeviceType(
                ua != null && ua.toLowerCase().contains("mobile")
                        ? "Mobile"
                        : "Desktop"
        );

        audit.setSuccessful(success);
        audit.setFailedAttemptCount(success ? 0 : 1);
        audit.setTwoFactorVerified(false);

        auditRepo.save(audit);

        // ====== LOGIN SUCCESS ======
        if (success) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user); // SIMPAN OBJECT USER
            response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=true");
        }
    }
}
