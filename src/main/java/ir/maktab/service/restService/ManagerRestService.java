package ir.maktab.service.restService;

import ir.maktab.dto.SuggestionDto;
import ir.maktab.dto.restDto.SuggestionFilterDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ManagerRestService {
    List<SuggestionDto> filterSuggestions(SuggestionFilterDto dto);

}
