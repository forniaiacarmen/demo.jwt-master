package com.forniaia.demo.jwt.service;

import com.forniaia.demo.jwt.model.ClockInOut;
import com.forniaia.demo.jwt.repository.ClockInOutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClockInOutService {

    private final ClockInOutRepository clockInOutRepository;

    public ClockInOut createClockInOut(ClockInOut clockInOut) {
        return clockInOutRepository.save(clockInOut);
    }
}
