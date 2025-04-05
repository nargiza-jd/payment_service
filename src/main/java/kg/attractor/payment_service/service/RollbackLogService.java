package kg.attractor.payment_service.service;

import kg.attractor.payment_service.model.RollbackLog;

import java.util.List;

public interface RollbackLogService {
    void logRollback(Long transactionId, String reason);
    List<RollbackLog> getAllLogs();
    void deleteLog(Long id);
}