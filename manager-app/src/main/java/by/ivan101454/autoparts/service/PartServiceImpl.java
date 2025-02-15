package by.ivan101454.autoparts.service;

import by.ivan101454.autoparts.dto.PartDto;
import by.ivan101454.autoparts.entity.Part;
import by.ivan101454.autoparts.mapper.PartMapper;
import by.ivan101454.autoparts.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final PartMapper partMapper = PartMapper.INSTANCE;

    @Override
    public List<Part> findAllParts() {
        return partRepository.findAll();
    }

    @Override
    public PartDto createPart(PartDto partDto) {
        Part newPart = partMapper.partDtoToPart(partDto);
        Part part = partRepository.save(newPart);
        return partMapper.partToPartDto(part);
    }
}
