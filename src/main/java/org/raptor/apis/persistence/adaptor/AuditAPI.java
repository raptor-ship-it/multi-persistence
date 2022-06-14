package org.raptor.apis.persistence.adaptor;

import org.raptor.apis.persistence.domain.integration.model.Audit;
import org.raptor.apis.persistence.service.AuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditAPI {

    /** --- member variables --- */
    private final static Logger LOGGER = LoggerFactory.getLogger(AuditAPI.class);
    @Autowired
    private AuditService auditService;

    public AuditAPI() {
        super();
    }

    @GetMapping(path = "/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllAPIAudit() {
        System.out.println("audit API");
        LOGGER.info("audit" , "getAllAPIAudit");
        /* --- create a new audit for this call --- */
        final Audit audit = new Audit();
        audit.setApiName("getAllAPIAudit");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        audit.setTimestamp(dtf.format(now));
        auditService.createAPIAudit(audit);

        final List<Audit> audits =  auditService.getAllAPIAudits();
        ResponseEntity<?> response;
        if ( audits == null  || audits.isEmpty() ) {
            response = new ResponseEntity<>("no API audits found." , HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<>("API audits found." + audits,  HttpStatus.FOUND);
        }

        return response;
    }

}
