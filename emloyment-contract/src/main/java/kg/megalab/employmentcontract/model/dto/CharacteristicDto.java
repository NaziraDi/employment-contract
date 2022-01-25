package kg.megalab.employmentcontract.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CharacteristicDto {
    Long id;
    String softSkills;
    String hardSkills;
    String languages;
    EmployeeDto employee;
}
