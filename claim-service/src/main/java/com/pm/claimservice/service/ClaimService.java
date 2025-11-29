package com.pm.claimservice.service;

import com.pm.claimservice.dto.CreateClaimRequest;
import com.pm.claimservice.dto.UpdateClaimRequest;
import com.pm.claimservice.exeception.ClaimNotFoundException;
import com.pm.claimservice.model.Claim;
import com.pm.claimservice.model.ClaimStatus;
import com.pm.claimservice.repository.ClaimRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;

    public ClaimService(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    public Claim createClaim(CreateClaimRequest request){

        Claim claim = new Claim();
        claim.setPatientId(request.getPatientId());
        claim.setAmount(request.getAmount());
        claim.setDiagnosisCode(request.getDiagnosisCode());
        claim.setStatus(ClaimStatus.CREATED);
        claim.setCreatedAt(Instant.now());

        return claimRepository.save(claim);
    }

    public List<Claim> getAllClaims(){
        return claimRepository.findAll();
    }

    public Claim getClaimById(Long id){
        return claimRepository.findById(id).orElseThrow(() -> new ClaimNotFoundException(id));
    }

    public Claim updateClaim(Long id, UpdateClaimRequest request){
        Claim claim = getClaimById(id);

            if (request.getAmount() != null) {
                claim.setAmount(request.getAmount());
            }

            if (request.getDiagnosisCode() != null) {
                claim.setDiagnosisCode(request.getDiagnosisCode());
            }

            if (request.getStatus() != null) {
                claim.setStatus(request.getStatus());
            }

            return claimRepository.save(claim);
    }

    public void deleteClaimById(Long id){
        Claim claim = getClaimById(id);
        claimRepository.delete(claim);
    }
}
