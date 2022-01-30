package kg.megalab.employmentcontract.service.impl;

import kg.megalab.employmentcontract.mapper.EmployeeMapper;
import kg.megalab.employmentcontract.mapper.SalaryMapper;
import kg.megalab.employmentcontract.model.dto.EmployeeDto;
import kg.megalab.employmentcontract.model.dto.SalaryDto;
import kg.megalab.employmentcontract.model.entity.Salary;
import kg.megalab.employmentcontract.model.request.CreateSalaryRequest;
import kg.megalab.employmentcontract.repository.SalaryRepository;
import kg.megalab.employmentcontract.service.EmployeeService;
import kg.megalab.employmentcontract.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {

    private final SalaryRepository salaryRepository;
    private final EmployeeService employeeService;

    @Override
    public SalaryDto create(CreateSalaryRequest request){

        EmployeeDto employeeDto = employeeService.findById(request.getEmployeeId());

        Salary salary = Salary
                .builder()
                .amount(request.getAmount())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .isActive(true)
                .build();
        salary.setEmployee(EmployeeMapper.INSTANCE.toEntity(employeeDto));
        SalaryDto salaryDto = SalaryMapper.INSTANCE.toDto(salary);
        
        salaryRepository.save(salary);

        return salaryDto;
    }

    @Override
    public SalaryDto delete(Long id) {
        Salary salary = salaryRepository
                .findById(id)
                .map(salary1 -> {
                    salary1.setIsActive(false);
                    return salaryRepository.save(salary1);
                }).orElseThrow(() -> new RuntimeException("Salary is not found or already deleted"));
        return SalaryMapper.INSTANCE.toDto(salary);
    }

    @Override
    public SalaryDto findById(Long id) {
        Salary salary = salaryRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Salary with id " + id + " not found"));
        return SalaryMapper.INSTANCE.toDto(salary);
    }
}
