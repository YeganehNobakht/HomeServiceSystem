package ir.maktab.service.suggestionService;

import ir.maktab.data.entity.Suggestion;
import ir.maktab.data.repository.suggestion.SuggestionRepository;
import ir.maktab.dto.CustomerOrderDto;
import ir.maktab.dto.SuggestionDto;
import ir.maktab.service.mapper.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository suggestionRepository;
    private final Mapper mapper;

    public SuggestionServiceImpl(SuggestionRepository suggestionRepository, Mapper mapper) {
        this.suggestionRepository = suggestionRepository;
        this.mapper = mapper;
    }

    @Override
    public void addSuggestionForOrder(SuggestionDto suggestionDto) {
        suggestionRepository.save(mapper.toSuggestion(suggestionDto));
        CustomerOrderDto customerOrderDto = suggestionDto.getCustomerOrder();
    }

    @Override
    public List<SuggestionDto> filterUser(SuggestionDto suggestionDto) {
        List<Suggestion> all = suggestionRepository.findAll(SuggestionRepository.filterSuggestion(mapper.toSuggestion(suggestionDto)));
        return all.stream().map(mapper::toSuggestionDto).collect(Collectors.toList());
    }
}
