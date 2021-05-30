package ir.maktab.service.userService;

import ir.maktab.data.entity.User;

import java.util.List;

public interface UserService {
    List<User> filterUser(User user);
}
