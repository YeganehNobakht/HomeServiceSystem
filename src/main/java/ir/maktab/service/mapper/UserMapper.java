package ir.maktab.service.mapper;

import ir.maktab.data.entity.User;
import ir.maktab.dto.UserDto;

/**
 * @author Yeganeh Nobakht
 **/
public interface UserMapper {

    User toUser(UserDto userDto);
    UserDto toUserDto(User user);
}
