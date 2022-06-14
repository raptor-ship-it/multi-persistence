package org.raptor.apis.persistence.domain.integration.data.mongo;

import org.raptor.apis.persistence.domain.integration.model.Audit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuditRepository extends MongoRepository<Audit, String> {}
