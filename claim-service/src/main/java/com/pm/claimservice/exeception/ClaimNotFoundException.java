package com.pm.claimservice.exeception;

public class ClaimNotFoundException extends RuntimeException {
    public ClaimNotFoundException(Long id) {
        super("Claim not found: " + id);
    }
}
