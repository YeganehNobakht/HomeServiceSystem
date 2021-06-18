package ir.maktab.service.suggestionService;

import ir.maktab.data.entity.Specialist;
import ir.maktab.data.entity.Suggestion;
import ir.maktab.data.entity.enums.OrderStatus;
import ir.maktab.data.entity.enums.SuggestionStatus;
import ir.maktab.data.repository.suggestion.SuggestionRepository;
import ir.maktab.dto.CustomerOrderDto;
import ir.maktab.dto.SpecialistDto;
import ir.maktab.dto.SuggestionDto;
import ir.maktab.service.customerOrderService.CustomerOrderService;
import ir.maktab.service.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository suggestionRepository;
    private final Mapper mapper;
    private final CustomerOrderService customerOrderService;

    public SuggestionServiceImpl(SuggestionRepository suggestionRepository, Mapper mapper, CustomerOrderService customerOrderService) {
        this.suggestionRepository = suggestionRepository;
        this.mapper = mapper;
        this.customerOrderService = customerOrderService;
    }

    @Override
    public void addSuggestionForOrder(SuggestionDto suggestionDto) {
        Suggestion suggestion = suggestionRepository.save(mapper.toSuggestion(suggestionDto));

    }

    @Override
    public List<SuggestionDto> filterSuggestion(SuggestionDto suggestionDto) {
        List<Suggestion> all = suggestionRepository.findAll(SuggestionRepository.filterSuggestion(mapper.toSuggestion(suggestionDto)));
        return all.stream().map(mapper::toSuggestionDto).collect(Collectors.toList());
    }

    @Override
    public List<SuggestionDto> findByCustomerOrder(CustomerOrderDto order) throws Exception {
        if (order.getOrderStatus().equals(OrderStatus.WAITING_FOR_SPECIALIST_OFFER)){
            List<Suggestion> suggestions = suggestionRepository.findByCustomerOrder_Id(order.getId());
            if (suggestions.size()==0)
                throw new Exception("No suggestion yet.");
            return suggestions.stream().map(mapper::toSuggestionDto).collect(Collectors.toList());

        }
        throw new Exception("Your order already have suggestion");
        }

    @Override
    public List<SuggestionDto> findBySpecialist(SpecialistDto specialist)  {

        List<Suggestion> bySpecialist = suggestionRepository.findBySpecialist(mapper.toSpecialist(specialist));
        return bySpecialist.stream().map(mapper::toSuggestionDto).collect(Collectors.toList());
    }

    @Override
    public SuggestionDto findBySpecialist_IdAndOrderId(Integer specialistId, Integer orderId) {
        Suggestion suggestion = suggestionRepository.findBySpecialist_IdAndAndCustomerOrder_Id(specialistId, orderId);
        if (suggestion==null)
            return null;
        return mapper.toSuggestionDto(suggestion);
    }

    @Override
    public SuggestionDto findById(Integer id) throws Exception {
        Optional<Suggestion> suggestion = suggestionRepository.findById(id);
        if (suggestion.isPresent())
            return mapper.toSuggestionDto(suggestion.get());
        throw  new Exception("No Such Suggestion");
    }

    @Override
    public SuggestionDto update(SuggestionDto suggestionDto) {
//        if (suggestionRepository.findById(suggestionDto.getId()).isPresent()) {
            //using save method for update
            return  mapper.toSuggestionDto(suggestionRepository.save(mapper.toSuggestion(suggestionDto)));
//        } else
//            throw new Exception("No such specialist found");
    }

    @Override
    public List<SuggestionDto> findUserBySuggestionStatusAndSpecialist(SuggestionStatus status, Integer id) {
        List<Suggestion> suggestionList = suggestionRepository.findUserBySuggestionStatusAndSpecialist(status, id);
        return suggestionList.stream().map(mapper::toSuggestionDto).collect(Collectors.toList());
    }
}
