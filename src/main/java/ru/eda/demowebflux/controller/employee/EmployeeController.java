package ru.eda.demowebflux.controller.employee;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.eda.demowebflux.controller.employee.dto.EmployeeFactory;
import ru.eda.demowebflux.controller.employee.dto.create.EmployeeCreateRequestDTO;
import ru.eda.demowebflux.controller.employee.dto.create.EmployeeCreateResponseDTO;
import ru.eda.demowebflux.controller.employee.dto.update.EmployeeUpdateRequestDTO;
import ru.eda.demowebflux.controller.employee.dto.update.EmployeeUpdateResponseDTO;
import ru.eda.demowebflux.domain.employee.Employee;
import ru.eda.demowebflux.service.employee.EmployeeService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ApiOperation("Create Employee")
    public EmployeeCreateResponseDTO create(
            @ApiParam(value = "Employee create request object", required = true)
            @RequestBody
            @Valid EmployeeCreateRequestDTO createRequestDTO) {
        return EmployeeCreateResponseDTO.of(
                employeeService.create(EmployeeFactory.from(createRequestDTO))
        );
    }

    @GetMapping("/{id}")
    @ApiOperation("Get Employee")
    public Employee get(
            @ApiParam(value = "id of requested Entity to read", required = true)
            @PathVariable
            @Positive Long id) {
        return employeeService.getById(id);
    }

    @PutMapping
    @ApiOperation("Update Employee")
    public EmployeeUpdateResponseDTO update(
            @ApiParam(value = "Employee update request object", required = true)
            @RequestBody
            @Valid EmployeeUpdateRequestDTO updateRequestDTO) {
        return EmployeeUpdateResponseDTO.of(
                employeeService.update(EmployeeFactory.from(updateRequestDTO))
        );
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Employee")
    public void delete(
            @ApiParam(value = "id of requested Employee to delete", required = true)
            @PathVariable
            @Positive Long id) {
        employeeService.deleteById(id);
    }

}
