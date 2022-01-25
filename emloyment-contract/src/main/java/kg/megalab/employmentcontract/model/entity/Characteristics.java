package kg.megalab.employmentcontract.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_address")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class Characteristics  extends AbstractPersistable {

    @Column(name = "soft_skills", nullable = true)
    String softSkills;

    @Column(name = "hard_skills", nullable = true)
    String hardSkills;

    @Column(name = "languages", nullable = true)
    String languages;

}
