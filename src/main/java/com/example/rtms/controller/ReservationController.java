package com.example.rtms.controller;

/*
 * @author Kshitij
 * @created 30-Aug-2024
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    @GetMapping
    public String hello() {
        return "Hello";
    }
}
