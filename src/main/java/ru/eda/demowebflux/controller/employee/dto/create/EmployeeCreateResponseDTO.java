package ru.eda.demowebflux.controller.employee.dto.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.eda.demowebflux.domain.employee.Employee;

@ApiModel(description = "Employee create response object, which contains response information")
public class EmployeeCreateResponseDTO {
    @ApiModelProperty(notes = "Employee id")
    private final Long id;

    @ApiModelProperty(notes = "Employee name")
    private final String name;

    public static EmployeeCreateResponseDTO of(Employee employee) {
        return new EmployeeCreateResponseDTO(
                employee.getId(),
                employee.getName()
        );
    }

    public EmployeeCreateResponseDTO(Long id, String name) {
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
