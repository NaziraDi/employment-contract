package kg.megalab.employmentcontract.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    Employee employee;
}
