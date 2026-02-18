package repository;

import model.LoginAudit;

public interface LoginAuditRepository {
    void save(LoginAudit audit);
}