package by.ivan101454.catalogue.service;

import by.ivan101454.catalogue.dto.PartDto;
import by.ivan101454.catalogue.entity.Part;
import by.ivan101454.catalogue.mapper.PartMapper;
import by.ivan101454.catalogue.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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
        Iterable<Part> all = partRepository.findAll();
        Iterator<Part> iterator = all.iterator();
        ArrayList<PartDto> partDtos = new ArrayList<>();
        while (iterator.hasNext()) {
            Part next = iterator.next();
            PartDto partDto = partMapper.partToPartDto(next);
            partDtos.add(partDto);
        }
        return partDtos;
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
                    .ifPresentOrElse(partRepository::delete, () -> {throw new NoSuchElementException();});
    }
}
