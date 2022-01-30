package kg.megalab.employmentcontract.mapper;

import kg.megalab.employmentcontract.model.dto.EmployeesInProjectDto;
import kg.megalab.employmentcontract.model.entity.EmployeesInProject;
import org.mapstruct.factory.Mappers;

public interface EmployeesInProjectMapper extends BaseMapper<EmployeesInProject, EmployeesInProjectDto> {
    EmployeesInProjectMapper INSTANCE = Mappers.getMapper(EmployeesInProjectMapper.class);
}
