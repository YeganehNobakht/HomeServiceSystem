package ir.maktab.service.suggestionService;

import ir.maktab.data.entity.User;
import ir.maktab.dto.SuggestionDto;

import java.util.List;

public interface SuggestionService {

    void addSuggestionForOrder(SuggestionDto suggestionDto);

    public List<SuggestionDto> filterUser(SuggestionDto suggestionDto);
    //void updateSuggestion(SuggestionDto suggestionDto);

}
