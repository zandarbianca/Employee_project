package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmplyeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmplyeeRepo emplyeeRepo;

    @Autowired
    public EmployeeService(EmplyeeRepo emplyeeRepo) {
        this.emplyeeRepo = emplyeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return emplyeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return emplyeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return emplyeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return emplyeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
    }

    public void deleteEmployee(Long id){
        emplyeeRepo.deleteEmployeeById(id);
    }
}
