package ru.eda.demowebflux.controller.employee.dto;

import ru.eda.demowebflux.controller.employee.dto.create.EmployeeCreateRequestDTO;
import ru.eda.demowebflux.controller.employee.dto.update.EmployeeUpdateRequestDTO;
import ru.eda.demowebflux.domain.employee.Employee;

import java.util.Optional;

public final class EmployeeFactory {

    private EmployeeFactory() {
    }

    public static Employee from(EmployeeCreateRequestDTO createRequestDTO) {
        return Optional.ofNullable(createRequestDTO)
                .map(EmployeeCreateRequestDTO::getName)
                .map(Employee::new)
                .orElse(null);
    }

    public static Employee from(EmployeeUpdateRequestDTO updateRequestDTO) {
        return Optional.ofNullable(updateRequestDTO)
                .map(EmployeeUpdateRequestDTO::getName)
                .map(Employee::new)
                .orElse(null);
    }
}