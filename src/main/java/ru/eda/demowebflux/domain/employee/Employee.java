package ru.eda.demowebflux.domain.employee;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
@ApiModel(description = "All details about Employee")
public class Employee {

    @Id
    @ApiModelProperty(notes = "Employee id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    @SequenceGenerator(name = "employee_generator", sequenceName = "employees_id_seq", allocationSize = 1)
    private Long id;

    @ApiModelProperty(notes = "Employee name")
    private String name;

    public Employee() {}

    public Employee(String name) {
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