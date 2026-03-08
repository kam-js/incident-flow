package org.incidentflow.incidentservice.dto;

import lombok.*;
import org.incidentflow.incidentservice.model.IncidentSeverity;

@Getter
@Setter
public class CreateIncidentRequest {
    private String title;
    private String description;
    private IncidentSeverity severity;
}
