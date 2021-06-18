package ir.maktab.service.userService;

import ir.maktab.data.entity.User;
import ir.maktab.dto.UserDto;
import ir.maktab.dto.UserFilter;

import java.util.List;

public interface UserService {

    List<UserDto> filterUser(UserFilter user) throws Exception;

    List<UserDto> findAll();
}
