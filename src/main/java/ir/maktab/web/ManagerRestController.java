package ir.maktab.web;

import ir.maktab.dto.SuggestionDto;
import ir.maktab.dto.restDto.SuggestionFilterDto;
import ir.maktab.service.restService.ManagerRestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/managerRestController")
public class ManagerRestController {
    private final ManagerRestService managerRestService;

    public ManagerRestController(ManagerRestService managerRestService) {
        this.managerRestService = managerRestService;
    }


    @PostMapping(value = "/filterSuggestions", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> filterOffers(@RequestBody @Valid SuggestionFilterDto dto) {
        List<SuggestionDto> suggestionDtoList = managerRestService.filterSuggestions(dto);
        return new ResponseEntity<>(suggestionDtoList, HttpStatus.OK);
    }

}
