package org.incidentflow.incidentservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "incidents")
public class Incident {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private IncidentStatus status;

    @Enumerated(EnumType.STRING)
    private IncidentSeverity severity;

    private String owner;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    public Incident() {
    }

}
