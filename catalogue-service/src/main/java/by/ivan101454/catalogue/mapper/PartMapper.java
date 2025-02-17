package by.ivan101454.catalogue.mapper;

import by.ivan101454.catalogue.dto.PartDto;
import by.ivan101454.catalogue.entity.Part;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PartMapper {

    PartMapper INSTANCE = Mappers.getMapper(PartMapper.class);
    @Mappings({@Mapping(target = "codeCarCountry", ignore = true), @Mapping(target = "numberCar", ignore = true)})
    PartDto partToPartDto(Part part);
    @Mappings({@Mapping(target = "car", ignore = true), @Mapping(target = "id", ignore = true)})
    Part partDtoToPart(PartDto partDto);

}
