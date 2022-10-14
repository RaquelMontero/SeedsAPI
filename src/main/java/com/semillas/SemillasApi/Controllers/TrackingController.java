package com.semillas.SemillasApi.Controllers;

import com.semillas.SemillasApi.DTO.Format.Table;
import com.semillas.SemillasApi.Entities.Seeds.UniqueAplicantHolder;
import com.semillas.SemillasApi.Entities.SeedsTracking.TrackingAssignment;
import com.semillas.SemillasApi.Service.TrackingAssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/seeds/trackingassignment")
public class TrackingController {
    @Inject
    TrackingAssignmentService trackingAssignmentService;

    @GetMapping(path = {"/trackingSeeds"})
    public Table gettrackingSeeds(@RequestParam(required = true) Long id){
        return trackingAssignmentService.findtrackingSeeds(id);
    }

    @PostMapping(path = {"/createAssinment"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createUniqueApplicant(@RequestBody TrackingAssignment trackingAssignment) {
        trackingAssignmentService.saveTrackingAssignment(trackingAssignment);
    }
}
