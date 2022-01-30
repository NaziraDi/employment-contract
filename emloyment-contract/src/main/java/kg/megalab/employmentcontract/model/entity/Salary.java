package kg.megalab.employmentcontract.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_salary")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class Salary extends AbstractPersistable {

    @Column(name = "amount", nullable = false)
    BigDecimal amount;

    @Column(name = "start_date", nullable = false)
    LocalDate startDate;

    @Column(name = "end_date", columnDefinition = "31.12.2999")
    LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    Employee employee;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    Boolean isActive;
}
