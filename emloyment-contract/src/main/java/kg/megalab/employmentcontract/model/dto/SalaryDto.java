package kg.megalab.employmentcontract.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalaryDto {
    Long id;
    BigDecimal amount;
    LocalDate startDate;
    LocalDate endDate;
    Long employeeId;
    Boolean isActive;
}
