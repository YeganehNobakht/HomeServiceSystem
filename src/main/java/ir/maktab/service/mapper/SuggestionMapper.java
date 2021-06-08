package ir.maktab.service.mapper;

import ir.maktab.data.entity.Suggestion;
import ir.maktab.dto.SuggestionDto;
import org.springframework.stereotype.Component;

@Component
public class SuggestionMapper {

    private final Mapper mapper;

    public SuggestionMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    Suggestion toSuggestion(SuggestionDto suggestionDto){
        return new Suggestion()
                .setCustomerOrder(mapper.toCustomerOrder(suggestionDto.getCustomerOrder()))
                .setDurationOfWork(suggestionDto.getDurationOfWork())
                .setId(suggestionDto.getId())
                .setPrice(suggestionDto.getPrice())
                .setSpecialist(mapper.toSpecialist(suggestionDto.getSpecialistDto()))
                .setStartTime(suggestionDto.getStartTime())
                .setWorkDescription(suggestionDto.getWorkDescription());
    }
    SuggestionDto toSuggestionDto(Suggestion suggestion){
        return new SuggestionDto()
                .setCustomerOrder(mapper.toCustomerOrderDto(suggestion.getCustomerOrder()))
                .setDurationOfWork(suggestion.getDurationOfWork())
                .setId(suggestion.getId())
                .setPrice(suggestion.getPrice())
                .setSpecialistDto(mapper.toSpecialistDto(suggestion.getSpecialist()))
                .setStartTime(suggestion.getStartTime())
                .setWorkDescription(suggestion.getWorkDescription());
    }
}
