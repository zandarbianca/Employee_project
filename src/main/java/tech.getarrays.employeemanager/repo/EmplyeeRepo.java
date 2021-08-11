package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Employee;

import java.util.Optional;

public interface EmplyeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id); // spring do this
    Optional<Employee> findEmployeeById(Long id);
}
