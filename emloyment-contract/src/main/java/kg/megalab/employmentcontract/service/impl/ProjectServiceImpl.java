package kg.megalab.employmentcontract.service.impl;

import kg.megalab.employmentcontract.mapper.PositionMapper;
import kg.megalab.employmentcontract.mapper.ProjectMapper;
import kg.megalab.employmentcontract.model.dto.ProjectDto;
import kg.megalab.employmentcontract.model.entity.Project;
import kg.megalab.employmentcontract.model.request.CreateProjectRequest;
import kg.megalab.employmentcontract.repository.ProjectRepository;
import kg.megalab.employmentcontract.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Override
    public ProjectDto create(CreateProjectRequest request) {
        Project project = Project
                .builder()
                .projectName(request.getProjectName())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .isActive(true)
                .build();
        projectRepository.save(project);
        ProjectDto projectDto = ProjectMapper.INSTANCE.toDto(project);

        return projectDto;
    }

    @Override
    public ProjectDto update(ProjectDto projectDto) {
        Project project = projectRepository
                .findById(projectDto.getId())
                .map(project1 -> {
                    project1.setProjectName(projectDto.getProjectName());
                    project1.setStartDate(projectDto.getStartDate());
                    project1.setEndDate(projectDto.getEndDate());
                    return projectRepository.save(project1);
                }).orElseThrow(() -> new RuntimeException("Not found"));
        return ProjectMapper.INSTANCE.toDto(project);
    }

    @Override
    public ProjectDto findById(Long id) {
        Project project = projectRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Project with id " + id + " not found"));
        return ProjectMapper.INSTANCE.toDto(project);
    }

    @Override
    public ProjectDto delete(Long id) {
        Project project = projectRepository
                .findById(id)
                .map(project1 -> {
                    project1.setIsActive(false);
                    return projectRepository.save(project1);
                }).orElseThrow(() -> new RuntimeException("Project is not found or already deleted"));
        return ProjectMapper.INSTANCE.toDto(project);
    }

    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }
}
