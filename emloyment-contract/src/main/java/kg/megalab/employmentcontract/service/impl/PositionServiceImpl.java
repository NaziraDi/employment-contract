package kg.megalab.employmentcontract.service.impl;

import kg.megalab.employmentcontract.mapper.PositionMapper;
import kg.megalab.employmentcontract.model.dto.PositionDto;
import kg.megalab.employmentcontract.model.entity.Position;
import kg.megalab.employmentcontract.model.request.CreatePositionRequest;
import kg.megalab.employmentcontract.repository.PositionRepository;
import kg.megalab.employmentcontract.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    @Override
    public PositionDto create(CreatePositionRequest request) {
        Position position = Position
                .builder()
                .positionTitle(request.getPositionTitle())
                .isActive(true)
                .build();
        positionRepository.save(position);
        PositionDto positionDto = PositionMapper.INSTANCE.toDto(position);

        return positionDto;
    }

    @Override
    public PositionDto update(PositionDto positionDto) {
        Position position = positionRepository
                .findById(positionDto.getId())
                .map(position1 -> {
                    position1.setPositionTitle(positionDto.getPositionTitle());
                    return positionRepository.save(position1);
                }).orElseThrow(() -> new RuntimeException("Not found"));
        return PositionMapper.INSTANCE.toDto(position);
    }

    @Override
    public PositionDto findById(Long id) {
        Position position = positionRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Position with id " + id + " not found"));
        return PositionMapper.INSTANCE.toDto(position);
    }

    @Override
    public PositionDto delete(Long id) {
        Position position = positionRepository
                .findById(id)
                .map(position1 -> {
                    position1.setIsActive(false);
                    return positionRepository.save(position1);
                }).orElseThrow(() -> new RuntimeException("Position not found or already deleted"));
        return PositionMapper.INSTANCE.toDto(position);
    }

    @Override
    public void save(Position position) {

        positionRepository.save(position);
    }
}
