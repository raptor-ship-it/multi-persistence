package org.raptor.apis.persistence.domain.integration.data.mysql;


import org.raptor.apis.persistence.domain.integration.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Students, Integer> {
}
