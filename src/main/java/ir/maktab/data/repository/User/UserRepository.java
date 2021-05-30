package ir.maktab.data.repository.User;

import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.entity.User;
import ir.maktab.dto.UserDto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {

//    List<UserDto> filterUser(UserDto userDto);

    static Specification<User> filterUser(User user){
        return (Specification<User>) (root, cq, cb) -> {
            ArrayList<Predicate> predicates = new ArrayList<>();

            //join<>
           // paganle.....sort(specialistRate)


//root:suggestion
            //Join<suggestion, CustomerOrder> order = root.join("order");
            //Join<suggestion, specialist> specialist = root.join("specialist");


            // cq.orderBy(cb.desc(root.get("price")))

           // cq.orderBy(cb.desc(specialist.get("specialistRate")))
            if (user.getName()!=null)
                predicates.add(cb.equal(root.get("name"),user.getName()));
            if (user.getLastName()!=null)
                predicates.add(cb.equal(root.get("lastName"),user.getLastName()));
            if (user.getUserRole()!=null)
                predicates.add(cb.equal(root.get("userRole"),user.getUserRole()));
            if (user.getEmail()!=null)
                predicates.add(cb.equal(root.get("email"),user.getEmail()));
            return cq.where(predicates.toArray(new Predicate[0])).getRestriction();
        };
    }
}
