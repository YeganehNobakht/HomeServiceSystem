package ir.maktab.service.userService;

import com.mysql.cj.util.StringUtils;
import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.data.entity.User;
import ir.maktab.data.repository.User.UserRepository;
import ir.maktab.dto.ServiceCategoryDto;
import ir.maktab.dto.UserDto;
import ir.maktab.dto.UserFilter;
import ir.maktab.service.mapper.Mapper;
import ir.maktab.service.mapper.UserMapper;
import ir.maktab.service.serviceCategory.ServiceCategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final Mapper mapper;
    private final ServiceCategoryService serviceCategoryService;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, Mapper mapper, ServiceCategoryService serviceCategoryService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.mapper = mapper;
        this.serviceCategoryService = serviceCategoryService;
    }


    @Override
    public List<UserDto> filterUser(UserFilter user) throws Exception {
        List<UserDto> userDtoList = new ArrayList<>();
        ServiceCategoryDto serviceCategoryDto =null;
        if (!StringUtils.isNullOrEmpty(user.getSpeciality())) {
            serviceCategoryDto = serviceCategoryService.getByName(user.getSpeciality());
        }
        ServiceCategory service = null;
        if (serviceCategoryDto!=null){
            service = mapper.toServiceCategory(serviceCategoryDto);
        }
        userDtoList.addAll(
                userRepository.findAll(UserRepository.filterCustomers(user,service))
                        .stream().map(userMapper::toUserDto).collect(Collectors.toList())
        );

//        userDtoList.addAll(
//                userRepository.findAll(UserRepository.filterSpecialists(user))
//                        .stream().map(userMapper::toUserDto).collect(Collectors.toList())
//        );

        return userDtoList;
    }

    @Override
    public List<UserDto> findAll() {
        List<User> all = userRepository.findAll();
        return all.stream().map(userMapper::toUserDto).collect(Collectors.toList());
    }
}
