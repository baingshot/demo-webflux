package ru.eda.demowebflux.controller.employee.dto.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.eda.demowebflux.domain.employee.Employee;

import java.util.Optional;

@ApiModel(description = "Employee update response object, which contains response information")
public class EmployeeUpdateResponseDTO {

    @ApiModelProperty(notes = "Employee id")
    private final Long id;

    @ApiModelProperty(notes = "Employee name")
    private final String name;

    public static EmployeeUpdateResponseDTO of(Employee employee) {
        return Optional.ofNullable(employee)
                .map(empl -> new EmployeeUpdateResponseDTO(
                        empl.getId(),
                        empl.getName()
                ))
                .orElse(null);
    }

    public EmployeeUpdateResponseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }
}