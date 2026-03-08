package org.incidentflow.incidentservice.repository;

import org.incidentflow.incidentservice.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IncidentRepository extends JpaRepository<Incident, UUID> {

}
