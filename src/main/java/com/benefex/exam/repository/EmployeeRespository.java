package com.benefex.exam.repository;

import com.benefex.exam.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRespository extends JpaRepository<Employee,Long> {

    @Query("SELECT MAX(e.employeeNo) FROM Employee e")
    Integer findMaxEmployeeNo();

    boolean existsByEmail(String email);

    Employee findByEmployeeNo(Integer employeeNo);
}
