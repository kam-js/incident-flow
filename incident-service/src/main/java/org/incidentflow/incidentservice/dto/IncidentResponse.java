package org.incidentflow.incidentservice.dto;

import lombok.*;
import org.incidentflow.incidentservice.model.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class IncidentResponse {

    private UUID id;
    private String title;
    private String description;
    private IncidentStatus status;
    private IncidentSeverity severity;
    private String owner;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
