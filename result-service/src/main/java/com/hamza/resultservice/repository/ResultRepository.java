package com.hamza.resultservice.repository;

import com.hamza.resultservice.model.ComputationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<ComputationResult, Long> {
}
