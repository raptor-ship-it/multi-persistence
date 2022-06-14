package org.raptor.apis.persistence.service;


import org.raptor.apis.persistence.domain.integration.data.mongo.AuditRepository;
import org.raptor.apis.persistence.domain.integration.model.Audit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService {

    /** --- member variables --- */
    private final static Logger LOGGER = LoggerFactory.getLogger(AuditService.class);

    @Autowired
    private AuditRepository auditRepository;

    public AuditService() {
        super();
    }

    public Audit createAPIAudit(final Audit audit) {
        LOGGER.info("audit" , audit);
        return auditRepository.save(audit);
    }

    public List<Audit> getAllAPIAudits() {
        return auditRepository.findAll();
    }

}