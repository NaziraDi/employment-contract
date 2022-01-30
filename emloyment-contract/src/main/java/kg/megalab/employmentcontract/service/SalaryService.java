package kg.megalab.employmentcontract.service;

import kg.megalab.employmentcontract.model.dto.SalaryDto;
import kg.megalab.employmentcontract.model.request.CreateSalaryRequest;
import org.springframework.stereotype.Service;

@Service
public interface SalaryService {
    SalaryDto create(CreateSalaryRequest request);
    SalaryDto delete(Long id);
    SalaryDto findById(Long id);
}
