package kg.megalab.employmentcontract.service;

import kg.megalab.employmentcontract.model.dto.PositionDto;
import kg.megalab.employmentcontract.model.entity.Position;
import kg.megalab.employmentcontract.model.request.CreatePositionRequest;
import org.springframework.stereotype.Service;

@Service
public interface PositionService {
    PositionDto create(CreatePositionRequest request);
    PositionDto update(PositionDto positionDto);
    PositionDto findById(Long id);
    PositionDto delete(Long id);
    void save(Position position);
}
