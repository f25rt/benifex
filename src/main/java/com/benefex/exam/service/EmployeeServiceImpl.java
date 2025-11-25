package com.benefex.exam.service;

import com.benefex.exam.CustomException;
import com.benefex.exam.entity.Employee;
import com.benefex.exam.mapper.EmployeeMapper;
import com.benefex.exam.model.EmployeePojo;
import com.benefex.exam.repository.EmployeeRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeMapper employeeMapper;
    private final EmployeeRespository employeeRespository;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeRespository employeeRespository) {
        this.employeeMapper = employeeMapper;
        this.employeeRespository = employeeRespository;
    }

    @Override
    public EmployeePojo addEmployee(EmployeePojo employeePojo) throws CustomException {
        Employee employee = employeeMapper.toEntity(employeePojo);
        Employee addedEmployee = null;

        if(!employeeRespository.existsByEmail(employee.getEmail())) {
            // generate employeeNo if not set
            if (employee.getEmployeeNo() == null) {
                Integer nextNo = getNextEmployeeNo();
                employee.setEmployeeNo(nextNo);
            }
            addedEmployee = employeeRespository.save(employee);
        }else{
            throw new CustomException("Duplicate Email");
        }

        return employeeMapper.toDto(addedEmployee);
    }

    @Override
    public List<EmployeePojo> getAllEmployees() {
        return employeeMapper.listOfEmployeestoDto(employeeRespository.findAll());
    }

    @Override
    public EmployeePojo getEmployeeDetail(Integer employeeNo) {
        return employeeMapper.toDto(employeeRespository.findByEmployeeNo(employeeNo));
    }

    private Integer getNextEmployeeNo() {
        Integer max = employeeRespository.findMaxEmployeeNo();
        return (max == null) ? 1 : max + 1;
    }
}
