package org.incidentflow.incidentservice.controller;

import org.incidentflow.incidentservice.dto.CreateIncidentRequest;
import org.incidentflow.incidentservice.dto.IncidentResponse;
import org.incidentflow.incidentservice.service.IncidentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IncidentResponse createIncident(@RequestBody CreateIncidentRequest createIncidentRequest) {
        return incidentService.createIncident(createIncidentRequest);
    }

    @GetMapping
    public List<IncidentResponse> getAllIncidents() {
        return incidentService.getAllIncidents();
    }

    @GetMapping("/{id}")
    public IncidentResponse getIncidentById(@PathVariable UUID id) {
        return incidentService.getIncidentById(id);
    }


}
