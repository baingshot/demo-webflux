package ru.eda.demowebflux.controller.employee.dto;

import ru.eda.demowebflux.controller.employee.dto.create.EmployeeCreateRequestDTO;
import ru.eda.demowebflux.controller.employee.dto.update.EmployeeUpdateRequestDTO;
import ru.eda.demowebflux.domain.employee.Employee;

public final class EmployeeFactory {
    private EmployeeFactory() {

    }

    public static Employee from(EmployeeCreateRequestDTO createRequestDTO) {
        return new Employee(createRequestDTO.getName());
    }

    public static Employee from(EmployeeUpdateRequestDTO updateRequestDTO) {
        return new Employee(updateRequestDTO.getName());
    }
}
