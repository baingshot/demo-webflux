package ru.eda.demowebflux.repository.employee;

import org.springframework.data.repository.CrudRepository;
import ru.eda.demowebflux.domain.employee.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
