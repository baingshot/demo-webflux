package ru.eda.demowebflux.controller.employee.dto.get;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.eda.demowebflux.domain.employee.Employee;

import java.util.Optional;

@ApiModel(description = "Employee get response object, which contains response information")
public class EmployeeGetResponseDTO {

    @ApiModelProperty(notes = "Employee id")
    private final Long id;

    @ApiModelProperty(notes = "Employee name")
    private final String name;

    public static EmployeeGetResponseDTO of(Employee employee) {
        return Optional.ofNullable(employee)
                .map(empl -> new EmployeeGetResponseDTO(
                        empl.getId(),
                        empl.getName()
                ))
                .orElse(null);
    }

    public EmployeeGetResponseDTO(Long id, String name) {
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