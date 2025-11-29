package com.pm.claimservice.controller;


import com.pm.claimservice.dto.CreateClaimRequest;
import com.pm.claimservice.dto.UpdateClaimRequest;
import com.pm.claimservice.model.Claim;
import com.pm.claimservice.service.ClaimService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/claims")
@Tag(name="Claims",description = "Claims for managing Patients")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController( ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    @Operation(summary = "Create a Claim")
    public ResponseEntity<Claim> createClaim(@RequestBody @Valid CreateClaimRequest request) {
        Claim c = claimService.createClaim(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }


    @GetMapping
    @Operation(summary = "Get all the Claims")
    public List<Claim> getAllClaims() {
        return claimService.getAllClaims();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Claim by iD")
    public Claim getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Claim by iD")
    public Claim updateClaim(@PathVariable Long id,
                             @RequestBody @Valid UpdateClaimRequest request) {
        return claimService.updateClaim(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Claim by iD")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        claimService.deleteClaimById(id);
        return ResponseEntity.noContent().build();
    }
}
