package kg.megalab.employmentcontract.service;

import kg.megalab.employmentcontract.model.dto.CharacteristicsDto;
import kg.megalab.employmentcontract.model.entity.Characteristics;
import kg.megalab.employmentcontract.model.request.CreateCharacteristicsRequest;
import org.springframework.stereotype.Service;

@Service
public interface CharacteristicsService {

    CharacteristicsDto findById(Long id);
    CharacteristicsDto update(CharacteristicsDto characteristicsDto);
    void save(Characteristics characteristics);

}
