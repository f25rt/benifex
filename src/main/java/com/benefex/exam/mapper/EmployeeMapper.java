package com.benefex.exam.mapper;

import com.benefex.exam.entity.Employee;
import com.benefex.exam.model.EmployeePojo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(EmployeePojo dto);

    EmployeePojo toDto(Employee entity);

    List<EmployeePojo> listOfEmployeestoDto(List<Employee> employees);
}
