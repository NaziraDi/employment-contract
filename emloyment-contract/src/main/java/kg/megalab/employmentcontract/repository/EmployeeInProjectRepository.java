package kg.megalab.employmentcontract.repository;

import kg.megalab.employmentcontract.model.entity.EmployeesInProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeInProjectRepository extends JpaRepository<EmployeesInProject, Long> {
}
