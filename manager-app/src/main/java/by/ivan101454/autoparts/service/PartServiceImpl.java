package by.ivan101454.autoparts.service;

import by.ivan101454.autoparts.dto.PartDto;
import by.ivan101454.autoparts.entity.Part;
import by.ivan101454.autoparts.mapper.PartMapper;
import by.ivan101454.autoparts.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final PartMapper partMapper = PartMapper.INSTANCE;

    @Override
    public List<PartDto> findAllParts() {
        return partRepository.findAll().stream().map(partMapper::partToPartDto).toList();
    }

    @Override
    public PartDto createPart(PartDto partDto) {
        Part newPart = partMapper.partDtoToPart(partDto);
        Part part = partRepository.save(newPart);
        return partMapper.partToPartDto(part);
    }

    @Override
    public Optional<PartDto> findPart(int partArticle) {
        return partRepository.findByArticle(partArticle).map(partMapper::partToPartDto);
    }

    @Override
    public void updatePart(PartDto partDto) {
        partRepository.findByArticle(partDto.article())
                .ifPresentOrElse(part -> {
                    part.setName(partDto.name());
                    part.setPrice(partDto.price());
                    part.setSide(partDto.side());
                    part.setDirection(partDto.direction());
                }, () -> {throw new NoSuchElementException();});
    }

    @Override
    public void delete(int article) {
        partRepository.findByArticle(article)
                .ifPresentOrElse(p -> partRepository.delete(article), () -> {throw new NoSuchElementException();});
    }
}
