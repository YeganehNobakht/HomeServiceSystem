package ir.maktab.service.mapper;

import ir.maktab.data.entity.Specialist;
import ir.maktab.dto.SpecialistDto;

public class SpecialistMapper {
    public Specialist toSpecialist(SpecialistDto specialistDto){
        return (Specialist) new Specialist().setProfilePicture(specialistDto.getProfilePicture())
                .setSpeciality(specialistDto.getSpecialty())
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
        return (SpecialistDto) new SpecialistDto().setProfilePicture(specialist.getProfilePicture())
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
