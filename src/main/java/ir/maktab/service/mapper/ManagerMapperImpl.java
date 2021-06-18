package ir.maktab.service.mapper;

import ir.maktab.data.entity.Manager;
import ir.maktab.dto.ManagerDto;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapperImpl implements ManagerMapper {
    @Override
    public ManagerDto toManagerDto(Manager manager) {
        return new ManagerDto()
                .setPassword(manager.getPassword())
                .setUsername(manager.getUsername());
    }

    @Override
    public Manager toManager(ManagerDto managerDto) {
        return new Manager()
                .setPassword(managerDto.getPassword())
                .setUsername(managerDto.getUsername());
    }
}
