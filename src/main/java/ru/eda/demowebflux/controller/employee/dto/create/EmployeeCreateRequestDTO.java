package ru.eda.demowebflux.controller.employee.dto.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(description = "Employee create request object, which contains request information")
public class EmployeeCreateRequestDTO {

    @NotBlank
    @Size(max = 32)
    @ApiModelProperty(notes = "Employee name")
    private final String name;

    public EmployeeCreateRequestDTO(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}