package repository.impl;

import config.DBConnection;
import model.LoginAudit;
import repository.LoginAuditRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LoginAuditRepositoryImpl implements LoginAuditRepository {

    @Override
    public void save(LoginAudit audit) {
        String sql = "INSERT INTO login_audit " +
                "(username, ip_address, user_agent, device_type, is_successful, failed_attempt_count, two_factor_verified) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, audit.getUsername());
            ps.setString(2, audit.getIpAddress());
            ps.setString(3, audit.getUserAgent());
            ps.setString(4, audit.getDeviceType());
            ps.setBoolean(5, audit.isSuccessful());
            ps.setInt(6, audit.getFailedAttemptCount());
            ps.setBoolean(7, audit.isTwoFactorVerified());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Audit insert failed: " + e.getMessage());
        }
    }
}