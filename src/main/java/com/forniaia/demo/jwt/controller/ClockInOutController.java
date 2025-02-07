package com.forniaia.demo.jwt.controller;

import com.forniaia.demo.jwt.model.ClockInOut;
import com.forniaia.demo.jwt.service.ClockInOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clockinout")
@RequiredArgsConstructor  // Automatically injects the ClockInOutService
public class ClockInOutController {

    private final ClockInOutService clockInOutService;

    @PostMapping
    public ResponseEntity<ClockInOut> createClockInOut(@RequestBody ClockInOut clockInOut) {
        ClockInOut createdClockInOut = clockInOutService.createClockInOut(clockInOut);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClockInOut);
    }
}
