package org.incidentflow.incidentservice.dto;

import lombok.*;
import org.incidentflow.incidentservice.model.IncidentStatus;

@Getter
@Setter
public class UpdateIncidentStatusRequest {
    private IncidentStatus status;
}
