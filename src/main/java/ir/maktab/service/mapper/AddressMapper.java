package ir.maktab.service.mapper;

import ir.maktab.data.entity.Address;
import ir.maktab.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address toAddress(AddressDto addressDto){
        return new Address()
                .setCity(addressDto.getCity())
                .setStreet(addressDto.getStreet())
                .setAlley(addressDto.getAlley());
    }
    public AddressDto toAddressDto(Address address){
        return new AddressDto()
                .setCity(address.getCity())
                .setStreet(address.getStreet())
                .setAlley(address.getAlley());
    }
}
