package ir.maktab.service.suggestionService;

import ir.maktab.data.entity.enums.OrderStatus;
import ir.maktab.data.entity.enums.SuggestionStatus;
import ir.maktab.dto.CustomerOrderDto;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.dto.SuggestionDto;

import java.util.List;

public interface SuggestionService {

    void addSuggestionForOrder(SuggestionDto suggestionDto);

    public List<SuggestionDto> filterSuggestion(SuggestionDto suggestionDto);
//    void updateSuggestion(SuggestionDto suggestionDto);
    List<SuggestionDto> findByCustomerOrder(CustomerOrderDto customerOrderDto) throws Exception;
    List<SuggestionDto> findBySpecialist(SpecialistDto specialist) ;
    SuggestionDto findBySpecialist_IdAndOrderId(Integer specialistId,Integer orderId) ;

    SuggestionDto findById(Integer id) throws Exception;

    SuggestionDto update(SuggestionDto suggestionDto) ;
    List<SuggestionDto> findUserBySuggestionStatusAndSpecialist(SuggestionStatus status, Integer id);
}
