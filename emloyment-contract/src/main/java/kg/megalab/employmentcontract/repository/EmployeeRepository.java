package kg.megalab.employmentcontract.repository;

import kg.megalab.employmentcontract.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByIdAndIsActiveTrue(Long id);

}
