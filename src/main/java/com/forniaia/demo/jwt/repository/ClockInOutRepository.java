package com.forniaia.demo.jwt.repository;

import com.forniaia.demo.jwt.model.ClockInOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClockInOutRepository extends JpaRepository<ClockInOut, Long> {
}
