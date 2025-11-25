package com.benefex.exam.service;

import com.benefex.exam.CustomException;
import com.benefex.exam.model.EmployeePojo;

import java.util.List;

public interface EmployeeService {

    EmployeePojo addEmployee(EmployeePojo employeePojo) throws CustomException;

    List<EmployeePojo> getAllEmployees();

    EmployeePojo getEmployeeDetail(Integer employeeNo);

}
