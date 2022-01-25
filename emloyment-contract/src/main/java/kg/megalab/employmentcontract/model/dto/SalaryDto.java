package kg.megalab.employmentcontract.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalaryDto {
    Long id;
    BigDecimal amount;
    EmployeeDto employee;
}
