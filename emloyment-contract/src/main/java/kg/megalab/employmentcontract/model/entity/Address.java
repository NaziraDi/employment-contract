package kg.megalab.employmentcontract.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_address")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class Address extends AbstractPersistable {

    @Column(name = "country", nullable = false)
    String country;

    @Column(name = "city", nullable = false)
    String city;

    @Column(name = "street", nullable = false)
    String street;

    @Column(name = "house", nullable = false)
    String house;

    @Column(name = "apartment", nullable = true)
    Integer apartment;

    @Column(name = "postcode", nullable = false)
    Integer postcode;

}
