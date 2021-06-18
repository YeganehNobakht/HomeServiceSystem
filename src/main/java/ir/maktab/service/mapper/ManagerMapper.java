package ir.maktab.service.mapper;

import ir.maktab.data.entity.Manager;
import ir.maktab.dto.ManagerDto;

public interface ManagerMapper {
    ManagerDto toManagerDto(Manager manager);
    Manager toManager(ManagerDto managerDto);
}
