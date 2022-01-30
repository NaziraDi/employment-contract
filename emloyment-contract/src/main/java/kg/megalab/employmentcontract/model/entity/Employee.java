package kg.megalab.employmentcontract.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class Employee extends AbstractPersistable {

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "patronymic", nullable = true)
    String patronymic;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    Position position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "characteristics_id", referencedColumnName = "id")
    Characteristics characteristics;

    @OneToMany(mappedBy = "employee")
    List<EmployeesInProject> employeeInProjects;

    @Column(name = "is_active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    Boolean isActive;

}
