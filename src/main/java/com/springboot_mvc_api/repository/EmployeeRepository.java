package com.springboot_mvc_api.repository;

import com.springboot_mvc_api.dto.EmployeeDTO;
import com.springboot_mvc_api.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
