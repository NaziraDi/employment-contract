package kg.megalab.employmentcontract.service.impl;

import kg.megalab.employmentcontract.mapper.CharacteristicsMapper;
import kg.megalab.employmentcontract.model.dto.CharacteristicsDto;
import kg.megalab.employmentcontract.model.entity.Characteristics;
import kg.megalab.employmentcontract.model.request.CreateCharacteristicsRequest;
import kg.megalab.employmentcontract.repository.CharacteristicsRepository;
import kg.megalab.employmentcontract.service.CharacteristicsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacteristicsServiceImpl implements CharacteristicsService {
    private final CharacteristicsRepository characteristicsRepository;

//    @Override
//    public CharacteristicsDto create(CreateCharacteristicsRequest request) {
//        Characteristics characteristics = Characteristics
//                .builder()
//                .softSkills(request.getSoftSkills())
//                .hardSkills(request.getHardSkills())
//                .languages(request.getLanguages())
//                .build();
//        characteristicsRepository.save(characteristics);
//        CharacteristicsDto characteristicsDto = CharacteristicsMapper.INSTANSE.toDto(characteristics);
//        return characteristicsDto;
//    }

    @Override
    public CharacteristicsDto findById(Long id) {
        return CharacteristicsMapper.INSTANCE
                .toDto(characteristicsRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Characteristics not found")));
    }

    @Override
    public CharacteristicsDto update(CharacteristicsDto characteristicsDto) {
        Characteristics characteristics = characteristicsRepository
                .findById(characteristicsDto.getId()).map(characteristics1 -> {
                    characteristics1.setSoftSkills(characteristicsDto.getSoftSkills());
                    characteristics1.setHardSkills(characteristicsDto.getHardSkills());
                    characteristics1.setLanguages(characteristicsDto.getLanguages());
                    return characteristicsRepository.save(characteristics1);
                }).orElseThrow(() -> new RuntimeException("Not found"));

        return CharacteristicsMapper.INSTANCE.toDto(characteristics);
    }

    @Override
    public void save(Characteristics characteristics) {
        characteristicsRepository.save(characteristics);
    }
//
//    @Override
//    public CharacteristicsDto delete(Long id) {
//        Characteristics characteristics = characteristicsRepository
//                .findById(id)
//                .map(characteristics1 -> {
//                    characteristics1.setIsActive(false);
//                    return characteristicsRepository.save(characteristics1);
//                }).orElseThrow(() -> new RuntimeException("Characteristics not found"));
//        return CharacteristicsMapper.INSTANCE.toDto(characteristics);
//
//    }

}
