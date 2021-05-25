package ir.maktab.service.mapper;

import ir.maktab.data.entity.Suggestion;
import ir.maktab.dto.SuggestionDto;

public class SuggestionMapper {

    Suggestion toSuggestion(SuggestionDto suggestionDto){
        return new Suggestion()
                .setCustomerOrder(suggestionDto.getCustomerOrder())
                .setDurationOfWork(suggestionDto.getDurationOfWork())
                .setId(suggestionDto.getId())
                .setPrice(suggestionDto.getPrice())
                .setSpecialist(suggestionDto.getSpecialist())
                .setStartTime(suggestionDto.getStartTime())
                .setWorkDescription(suggestionDto.getWorkDescription());
    }
    SuggestionDto toSuggestionDto(Suggestion suggestion){
        return new SuggestionDto()
                .setCustomerOrder(suggestion.getCustomerOrder())
                .setDurationOfWork(suggestion.getDurationOfWork())
                .setId(suggestion.getId())
                .setPrice(suggestion.getPrice())
                .setSpecialist(suggestion.getSpecialist())
                .setStartTime(suggestion.getStartTime())
                .setWorkDescription(suggestion.getWorkDescription());
    }
}
