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
@Table(name = "tb_address")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class Characteristics  extends AbstractPersistable {

    @ElementCollection
    @Column(name = "soft_skills", nullable = true)
    List<String> softSkills;

    @ElementCollection
    @Column(name = "hard_skills", nullable = true)
    List<String> hardSkills;

    @ElementCollection
    @Column(name = "languages", nullable = true)
    List<String> languages;

    @Column(name = "is_active", columnDefinition = "true")
    Boolean isActive;

}
