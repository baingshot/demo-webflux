package ru.eda.demowebflux.controller.employee.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@ApiModel(description = "Employee update request object, which contains request information")
public class EmployeeUpdateRequestDTO {
    @NotNull
    @Positive
    @ApiModelProperty(notes = "Employee id")
    private final Long id;

    @NotBlank
    @Size(max = 32)
    @ApiModelProperty(notes = "Employee name")
    private final String name;

    public EmployeeUpdateRequestDTO(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
