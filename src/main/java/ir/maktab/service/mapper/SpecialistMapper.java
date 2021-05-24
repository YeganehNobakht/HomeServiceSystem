package ir.maktab.service.mapper;

import ir.maktab.data.entity.Specialist;
import ir.maktab.dto.SpecialistDto;
import org.springframework.stereotype.Component;

@Component
public class SpecialistMapper {
    public Specialist toSpecialist(SpecialistDto specialistDto){
        return new Specialist().setProfilePicture(specialistDto.getProfilePicture())
                .setBalance(specialistDto.getBalance())
                .setDate(specialistDto.getDate())
                .setEmail(specialistDto.getEmail())
                .setName(specialistDto.getName())
                .setLastName(specialistDto.getLastName())
                .setPassword(specialistDto.getPassword())
                .setUsername(specialistDto.getUsername())
                .setUserStatus(specialistDto.getUserStatus());

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
                .setUserStatus(specialist.getUserStatus());

    }
}
