package com.zosh.controller;

import com.zosh.payload.request.AircraftRequest;
import com.zosh.payload.response.AircraftResponse;
import com.zosh.payload.response.ApiResponse;
import com.zosh.service.AircraftService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircrafts")
@RequiredArgsConstructor
public class AircraftController {

    private final AircraftService aircraftService;

    @PostMapping("/create")
    public ResponseEntity<AircraftResponse> createAircraft(
            @RequestBody @Valid AircraftRequest request,
            @RequestHeader("X-User-Id") Long userId
            ) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(aircraftService.createAircraft(request, userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AircraftResponse> getById(
            @PathVariable Long id) throws Exception {
        return ResponseEntity.ok(aircraftService.getById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<AircraftResponse>> listAllAircraft(
            @RequestHeader("X-User-Id") Long userId) throws Exception {
        return ResponseEntity.ok(aircraftService.listAllAircraftByOwner(userId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AircraftResponse> updateAircraft(
            @PathVariable Long id,
            @RequestHeader("X-User-Id") Long userId,
            @RequestBody AircraftRequest request) throws Exception {
        return ResponseEntity.ok(aircraftService.updateAircraft(id, request, userId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteAircraft(
            @PathVariable Long id,
            @RequestHeader("X-User_id") Long userId) throws Exception {
        aircraftService.deleteAircraft(id, userId);
        return ResponseEntity.ok(new ApiResponse("Aircraft deleted successfully"));
    }
}
