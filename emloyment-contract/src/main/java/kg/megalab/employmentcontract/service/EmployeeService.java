package kg.megalab.employmentcontract.service;

import kg.megalab.employmentcontract.model.dto.EmployeeDto;
import kg.megalab.employmentcontract.model.entity.Employee;
import kg.megalab.employmentcontract.model.request.CreateEmployeeRequest;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    EmployeeDto create(CreateEmployeeRequest request);
    EmployeeDto update(EmployeeDto employeeDto);
    EmployeeDto findById(Long id);
    EmployeeDto delete(Long id);
    void save(Employee employee);

}
