package com.pm.patient_service.repository;

import com.pm.patient_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//It is very close to DAO pattern where DAO classes are responsible for providing CRUD operations on database tables.
// However, if you are using Spring Data for managing database operations, then you should use Spring Data Repository interface.
@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, UUID id);

}
