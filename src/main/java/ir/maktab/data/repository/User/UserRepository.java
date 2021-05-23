package ir.maktab.data.repository.User;

import ir.maktab.dto.UserDto;

import java.util.List;

public interface UserRepository {

    List<UserDto> filterUser(UserDto userDto);
}
