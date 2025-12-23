package com.example.demo.controller;

import com.example.demo.domain.GradeCount;
import com.example.demo.domain.GradeCountDto;
import com.example.demo.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/count-by-grade")
    public List<GradeCount> getCountByGrade() {
        return customerService.getCustomerCountByGrade();
    }


    @GetMapping("/count-by-grade2")
    public List<GradeCountDto> getCountByGrade2() {
        return customerService.getCustomerCountByGrade2();
    }
}
