package kg.megalab.employmentcontract.service;

import kg.megalab.employmentcontract.model.dto.ProjectDto;
import kg.megalab.employmentcontract.model.entity.Project;
import kg.megalab.employmentcontract.model.request.CreateProjectRequest;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {
    ProjectDto create(CreateProjectRequest request);
    ProjectDto update(ProjectDto projectDto);
    ProjectDto findById(Long id);
    ProjectDto delete(Long id);
    void save(Project project);
}
