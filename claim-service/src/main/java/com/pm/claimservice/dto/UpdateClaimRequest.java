package com.pm.claimservice.dto;

import com.pm.claimservice.model.ClaimStatus;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class UpdateClaimRequest {

    @Positive
    private BigDecimal amount;

    private String diagnosisCode;

    private ClaimStatus status ;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public void setStatus(ClaimStatus status) {
        this.status = status;
    }
}
