package ru.eda.demowebflux.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eda.demowebflux.domain.employee.Employee;
import ru.eda.demowebflux.repository.employee.EmployeeRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class EmployeeService {

    private static final String EMPLOYEE_NOT_FOUND = "Employee with id: %d was not found";

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format(EMPLOYEE_NOT_FOUND,id))
        );
    }

    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format(EMPLOYEE_NOT_FOUND,id));
        }
        employeeRepository.deleteById(id);
    }

}
