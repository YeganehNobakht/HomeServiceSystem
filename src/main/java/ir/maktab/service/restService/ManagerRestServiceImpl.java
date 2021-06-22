package ir.maktab.service.restService;

import ir.maktab.data.entity.Suggestion;
import ir.maktab.data.repository.restSpecification.RestSpecifications;
import ir.maktab.data.repository.suggestion.SuggestionRepository;
import ir.maktab.dto.SuggestionDto;
import ir.maktab.dto.restDto.SuggestionFilterDto;
import ir.maktab.service.mapper.Mapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ManagerRestServiceImpl implements ManagerRestService {
    private final SuggestionRepository suggestionRepository;
    private final Mapper mapper;

    public ManagerRestServiceImpl(SuggestionRepository suggestionRepository, Mapper mapper) {
        this.suggestionRepository = suggestionRepository;
        this.mapper = mapper;
    }

    @Override
    public List<SuggestionDto> filterSuggestions(SuggestionFilterDto dto) {
//        List<Suggestion> all = suggestionRepository.findAll(Specification.where(RestSpecifications.filterSuggestion(dto)));
//        return all.stream().map(mapper::toSuggestionDto).collect(Collectors.toList());
        return null;
    }
}
