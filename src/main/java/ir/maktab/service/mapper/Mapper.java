package ir.maktab.service.mapper;

import ir.maktab.data.entity.*;
import ir.maktab.dto.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Mapper {
    private final AddressMapper addressMapper;

    public Mapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Customer toCustomer(CustomerDto customerDto){
        return new Customer()
                .setBalance(customerDto.getBalance())
                .setDate(customerDto.getDate())
                .setEmail(customerDto.getEmail())
                .setName(customerDto.getName())
                .setLastName(customerDto.getLastName())
                .setPassword(customerDto.getPassword())
                .setUsername(customerDto.getUsername())
                .setUserStatus(customerDto.getUserStatus())
                .setCustomerOrderList(customerDto.getCustomerOrderList().stream().map(this::toCustomerOrder).collect(Collectors.toList()))
                .setCustomerCommentList(customerDto.getCustomerCommentList().stream().map(this::toCustomerComment).collect(Collectors.toList()));
    }
    public CustomerDto toCustomerDto(Customer customer){
        return new CustomerDto()
                .setBalance(customer.getBalance())
                .setDate(customer.getDate())
                .setEmail(customer.getEmail())
                .setName(customer.getName())
                .setLastName(customer.getLastName())
                .setPassword(customer.getPassword())
                .setUsername(customer.getUsername())
                .setUserStatus(customer.getUserStatus())
                .setCustomerOrderList(customer.getCustomerOrderList().stream().map(this::toCustomerOrderDto).collect(Collectors.toList()))
                .setCustomerCommentList(customer.getCustomerCommentList().stream().map(this::toCustomerCommentDto).collect(Collectors.toList()));

    }

    public CustomerOrder toCustomerOrder(CustomerOrderDto customerOrderDto){
        return new CustomerOrder()
                .setAddress(addressMapper.toAddress(customerOrderDto.getAddressDto()))
                .setCustomer(toCustomer(customerOrderDto.getCustomerDto()))
                .setOrderDate(customerOrderDto.getOrderDate())
                .setOrderStatus(customerOrderDto.getOrderStatus())
                .setServiceCategory(customerOrderDto.getServiceCategory())
                .setSubCategory(customerOrderDto.getSubCategory())
                .setId(customerOrderDto.getId())
                .setJobDescription(customerOrderDto.getJobDescription())
                .setWorkDate(customerOrderDto.getWorkDate());
    }

    public CustomerOrderDto toCustomerOrderDto(CustomerOrder customerOrder) {
        return new CustomerOrderDto()
                .setAddressDto(addressMapper.toAddressDto(customerOrder.getAddress()))
                .setCustomerDto(toCustomerDto(customerOrder.getCustomer()))
                .setOrderDate(customerOrder.getOrderDate())
                .setOrderStatus(customerOrder.getOrderStatus())
                .setServiceCategory(customerOrder.getServiceCategory())
                .setSubCategory(customerOrder.getSubCategory())
                .setId(customerOrder.getId())
                .setJobDescription(customerOrder.getJobDescription())
                .setWorkDate(customerOrder.getWorkDate());
    }

    public SubCategoryDto toSubCategoryDto(SubCategory subCategory) {
        return new SubCategoryDto()
                .setId(subCategory.getId())
                .setName(subCategory.getName())
                .setCustomerOrderList(subCategory.getCustomerOrderList().stream().map(this::toCustomerOrderDto).collect(Collectors.toList()))
                .setServiceCategory(toServiceCategoryDto(subCategory.getServiceCategory()));
    }

    public SubCategory toSubCategory(SubCategoryDto subCategoryDto) {
        return new SubCategory()
                .setId(subCategoryDto.getId())
                .setName(subCategoryDto.getName())
                .setCustomerOrderList(subCategoryDto.getCustomerOrderList().stream().map(this::toCustomerOrder).collect(Collectors.toList()))
                .setServiceCategory(toServiceCategory(subCategoryDto.getServiceCategory()));
    }

    public ServiceCategory toServiceCategory(ServiceCategoryDto serviceCategoryDto){
        return new ServiceCategory()
                .setId(serviceCategoryDto.getId())
                .setName(serviceCategoryDto.getName())
                .setSubCategoryList(serviceCategoryDto.getSubCategoryList().stream().map(this::toSubCategory).collect(Collectors.toList()))
                .setCustomerOrderList(serviceCategoryDto.getCustomerOrderList().stream().map(this::toCustomerOrder).collect(Collectors.toList()))
                .setSpecialistList(serviceCategoryDto.getSpecialistList().stream().map(this::toSpecialist).collect(Collectors.toList()));
    }
    public ServiceCategoryDto toServiceCategoryDto(ServiceCategory serviceCategory){
        return new ServiceCategoryDto()
                .setId(serviceCategory.getId())
                .setName(serviceCategory.getName())
                .setSubCategoryList(serviceCategory.getSubCategoryList().stream().map(this::toSubCategoryDto).collect(Collectors.toList()))
                .setCustomerOrderList(serviceCategory.getCustomerOrderList().stream().map(this::toCustomerOrderDto).collect(Collectors.toList()))
                .setSpecialistList(serviceCategory.getSpecialistList().stream().map(this::toSpecialistDto).collect(Collectors.toList()));
    }

    public CustomerComment toCustomerComment(CustomerCommentDto customerCommentDto){
        return new CustomerComment()
                .setComment(customerCommentDto.getComment())
                .setCustomer(toCustomer(customerCommentDto.getCustomerDto()))
                .setId(customerCommentDto.getId())
                .setScore(customerCommentDto.getScore())
                .setSpecialist(toSpecialist(customerCommentDto.getSpecialistDto()));
    }
    public CustomerCommentDto toCustomerCommentDto(CustomerComment customerComment){
        return new CustomerCommentDto()
                .setComment(customerComment.getComment())
                .setCustomerDto(toCustomerDto(customerComment.getCustomer()))
                .setId(customerComment.getId())
                .setScore(customerComment.getScore())
                .setSpecialistDto(toSpecialistDto((customerComment.getSpecialist())));
    }

    public Specialist toSpecialist(SpecialistDto specialistDto){
        return new Specialist().setProfilePicture(specialistDto.getProfilePicture())
                .setBalance(specialistDto.getBalance())
                .setDate(specialistDto.getDate())
                .setEmail(specialistDto.getEmail())
                .setName(specialistDto.getName())
                .setLastName(specialistDto.getLastName())
                .setPassword(specialistDto.getPassword())
                .setUsername(specialistDto.getUsername())
                .setUserStatus(specialistDto.getUserStatus())
                .setServiceCategoryList(specialistDto.getServiceCategoryList().stream().map(this::toServiceCategory).collect(Collectors.toList()))
                .setCustomerCommentList(specialistDto.getCustomerCommentList().stream().map(this::toCustomerComment).collect(Collectors.toList()))
                .setSuggestionList(specialistDto.getSuggestionList().stream().map(s->toSuggestion(s)).collect(Collectors.toList()));

    }
    public SpecialistDto toSpecialistDto(Specialist specialist){
        return new SpecialistDto().setProfilePicture(specialist.getProfilePicture())
                .setBalance(specialist.getBalance())
                .setDate(specialist.getDate())
                .setEmail(specialist.getEmail())
                .setName(specialist.getName())
                .setLastName(specialist.getLastName())
                .setPassword(specialist.getPassword())
                .setUsername(specialist.getUsername())
                .setUserStatus(specialist.getUserStatus())
                .setServiceCategoryList(specialist.getServiceCategoryList().stream().map(this::toServiceCategoryDto).collect(Collectors.toList()))
                .setCustomerCommentList(specialist.getCustomerCommentList().stream().map(this::toCustomerCommentDto).collect(Collectors.toList()))
                .setSuggestionList(specialist.getSuggestionList().stream().map(s->toSuggestionDto(s)).collect(Collectors.toList()));

    }


    public Suggestion toSuggestion(SuggestionDto suggestionDto){
        return new Suggestion()
                .setCustomerOrder(toCustomerOrder(suggestionDto.getCustomerOrder()))
                .setDurationOfWork(suggestionDto.getDurationOfWork())
                .setId(suggestionDto.getId())
                .setPrice(suggestionDto.getPrice())
                .setSpecialist(toSpecialist(suggestionDto.getSpecialistDto()))
                .setStartTime(suggestionDto.getStartTime())
                .setWorkDescription(suggestionDto.getWorkDescription());
    }
    public SuggestionDto toSuggestionDto(Suggestion suggestion){
        return new SuggestionDto()
                .setCustomerOrder(toCustomerOrderDto(suggestion.getCustomerOrder()))
                .setDurationOfWork(suggestion.getDurationOfWork())
                .setId(suggestion.getId())
                .setPrice(suggestion.getPrice())
                .setSpecialistDto(toSpecialistDto(suggestion.getSpecialist()))
                .setStartTime(suggestion.getStartTime())
                .setWorkDescription(suggestion.getWorkDescription());
    }
}
