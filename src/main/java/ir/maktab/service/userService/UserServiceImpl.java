package ir.maktab.service.userService;

import ir.maktab.data.entity.User;
import ir.maktab.data.repository.User.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> filterUser(User user) {
        return userRepository.findAll(UserRepository.filterUser(user));
    }
}
