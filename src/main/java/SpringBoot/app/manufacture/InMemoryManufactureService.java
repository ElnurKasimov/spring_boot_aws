package SpringBoot.app.manufacture;

import SpringBoot.app.manufacture.Dto.ManufactureConverter;
import SpringBoot.app.manufacture.Dto.ManufactureDto;
import SpringBoot.app.product.Product;
import SpringBoot.app.product.dto.ProductConverter;
import SpringBoot.app.product.dto.ProductDto;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class InMemoryManufactureService implements ManufactureService {
    @Getter
    private Map<UUID, Manufacture> manufactures = new HashMap<>();


    @Override
    public Set<ManufactureDto> listAll() {
        return manufactures.values().stream().map(ManufactureConverter::from).collect(Collectors.toSet());
    }

    @Override
    public ManufactureDto getById(UUID id) {
          return ManufactureConverter.from(manufactures.get(id));
    }

    @Override
    public ManufactureDto getByName(String name) {
        return manufactures.values()
                .stream()
                .map(ManufactureConverter::from)
                .filter(manufactureDto -> manufactureDto.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Manufacture save(ManufactureDto manufactureDto) {
        if (manufactureDto.getId() == null) {
            manufactureDto.setId(UUID.randomUUID());
        }
        manufactures.put(manufactureDto.getId(), ManufactureConverter.to(manufactureDto));
        return ManufactureConverter.to(manufactureDto);
    }

    @Override
    public ManufactureDto deleteById(UUID id) {

        return null;
    }
}
