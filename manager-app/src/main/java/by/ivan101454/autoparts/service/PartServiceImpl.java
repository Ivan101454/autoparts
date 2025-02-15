package by.ivan101454.autoparts.service;

import by.ivan101454.autoparts.entity.Part;
import by.ivan101454.autoparts.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;

    @Override
    public List<Part> findAllParts() {
        return partRepository.findAll();
    }
}
