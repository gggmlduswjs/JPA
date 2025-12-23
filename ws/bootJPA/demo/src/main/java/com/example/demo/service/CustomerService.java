package com.example.demo.service;

import com.example.demo.domain.GradeCount;
import com.example.demo.domain.GradeCountDto;
import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    // 생성자 주입 (스프링 4.3 이상부터는 @Autowired 생략 가능)
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<GradeCount> getCustomerCountByGrade() {
        return customerRepository.countCustomersByGrade();
    }


    public List<GradeCountDto> getCustomerCountByGrade2() {
        return customerRepository.countCustomersByGrade2();
    }
}

