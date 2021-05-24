package ir.maktab.data.repository.User;

import ir.maktab.data.entity.User;
import ir.maktab.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,String> {

//    List<UserDto> filterUser(UserDto userDto);
}
