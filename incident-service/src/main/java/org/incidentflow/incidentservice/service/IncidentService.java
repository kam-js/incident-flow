package org.incidentflow.incidentservice.service;

import org.incidentflow.incidentservice.dto.*;
import org.incidentflow.incidentservice.model.*;
import org.incidentflow.incidentservice.repository.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    public IncidentResponse createIncident(CreateIncidentRequest request) {
        Incident incident = new Incident();

        incident.setTitle(request.getTitle());
        incident.setDescription(request.getDescription());
        incident.setSeverity(request.getSeverity());

        incident.setStatus(IncidentStatus.OPEN);

        Incident savedIncident = incidentRepository.save(incident);

        return mapToResponse(savedIncident);
    }

    public List<IncidentResponse> getAllIncidents() {
        List<Incident> incidents = incidentRepository.findAll();
        List<IncidentResponse> incidentResponseList = new ArrayList<>();

        for (Incident incident : incidents) {
            IncidentResponse incidentResponse = mapToResponse(incident);
            incidentResponseList.add(incidentResponse);
        }

        return incidentResponseList;
    }

    public IncidentResponse getIncidentById(UUID id) {
        return incidentRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException(
                        "Incident not found: " + id
                ));
    }

    private IncidentResponse mapToResponse(Incident incident) {
        IncidentResponse response = new IncidentResponse();

        response.setId(incident.getId());
        response.setTitle(incident.getTitle());
        response.setDescription(incident.getDescription());
        response.setSeverity(incident.getSeverity());
        response.setStatus(incident.getStatus());
        response.setOwner(incident.getOwner());
        response.setCreatedAt(incident.getCreatedAt());
        response.setUpdatedAt(incident.getUpdatedAt());

        return response;
    }
}
