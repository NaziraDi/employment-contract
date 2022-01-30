package kg.megalab.employmentcontract.service.impl;

import kg.megalab.employmentcontract.mapper.EmployeeMapper;
import kg.megalab.employmentcontract.mapper.PositionMapper;
import kg.megalab.employmentcontract.model.dto.EmployeeDto;
import kg.megalab.employmentcontract.model.dto.PositionDto;
import kg.megalab.employmentcontract.model.entity.Address;
import kg.megalab.employmentcontract.model.entity.Characteristics;
import kg.megalab.employmentcontract.model.entity.Employee;
import kg.megalab.employmentcontract.model.entity.Position;
import kg.megalab.employmentcontract.model.request.CreateEmployeeRequest;
import kg.megalab.employmentcontract.repository.EmployeeRepository;
import kg.megalab.employmentcontract.service.AddressService;
import kg.megalab.employmentcontract.service.CharacteristicsService;
import kg.megalab.employmentcontract.service.EmployeeService;
import kg.megalab.employmentcontract.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PositionService positionService;
    private final AddressService addressService;
    private final CharacteristicsService characteristicsService;

    @Override
    public EmployeeDto create(CreateEmployeeRequest request) {

        PositionDto positionDto = positionService.findById(request.getPositionId());
        Address address = Address
                .builder()
                .country("N/A")
                .city("N/A")
                .street("N/A")
                .house("N/A")
                .apartment(0)
                .postcode(0)
                .build();

        Characteristics characteristics = Characteristics
                .builder()
                .softSkills(new ArrayList<>())
                .hardSkills(new ArrayList<>())
                .languages(new ArrayList<>())
                .build();

        Employee employee = Employee
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .patronymic(request.getPatronymic())
                .position(PositionMapper.INSTANCE.toEntity(positionDto))
                .address(address)
                .characteristics(characteristics)
                .isActive(true)
                .build();

        addressService.save(address);
        characteristicsService.save(characteristics);
        employeeRepository.save(employee);
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.toDto(employee);

        return employeeDto;
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        Employee employee = employeeRepository
                .findById(employeeDto.getId())
                .map(employee1 -> {
                    employee1.setFirstName(employeeDto.getFirstName());
                    employee1.setLastName(employeeDto.getLastName());
                    employee1.setPatronymic(employeeDto.getPatronymic());
                    return employeeRepository.save(employee1);
                }).orElseThrow(() -> new RuntimeException("Not found"));
        return EmployeeMapper.INSTANCE.toDto(employee);
    }

    @Override
    public EmployeeDto findById(Long id) {
        Employee employee = employeeRepository
                .findByIdAndIsActiveTrue(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        return EmployeeMapper.INSTANCE.toDto(employee);
    }

    @Override
    public EmployeeDto delete(Long id) {
        Employee employee = employeeRepository
                .findByIdAndIsActiveTrue(id)
                .map(employee1 -> {
                    employee1.setIsActive(false);
                    return employeeRepository.save(employee1);
                }).orElseThrow(() -> new RuntimeException("Employee not found or already deleted"));
        return EmployeeMapper.INSTANCE.toDto(employee);
    }

    @Override
    public void save(Employee employee) {

        employeeRepository.save(employee);
    }
}
