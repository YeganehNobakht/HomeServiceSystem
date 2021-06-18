package ir.maktab.data.repository.User;

import com.mysql.cj.util.StringUtils;
import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.ServiceCategory;
import ir.maktab.data.entity.Specialist;
import ir.maktab.data.entity.User;
import ir.maktab.dto.UserFilter;
import ir.maktab.dto.enums.UserRole;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

//    List<UserDto> filterUser(UserDto userDto);

    static Specification<User> filterCustomers(UserFilter user, ServiceCategory serviceCategory) {
        return (Specification<User>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            CriteriaQuery<User> userCriteriaQuery = criteriaBuilder.createQuery(User.class);
            Subquery<Specialist> specialistSubquery = userCriteriaQuery.subquery(Specialist.class);
            Root<Specialist> specialistRoot = specialistSubquery.from(Specialist.class);

//            if (user.getUserRole().equals(UserRole.Specialist)){
//                userCriteriaQuery = criteriaBuilder.createQuery(Specialist.class);
//            }

            if (user.getUserRole()!=null) {
                predicates.add(criteriaBuilder.equal(root.get("userRole"), user.getUserRole()));
            }

            if (!StringUtils.isNullOrEmpty(user.getName())) {
                predicates.add(criteriaBuilder.equal(root.get("name"), user.getName()));
            }

            if (!StringUtils.isNullOrEmpty(user.getLastName())) {
                predicates.add(criteriaBuilder.equal(root.get("lastName"), user.getLastName()));
            }

            if (!StringUtils.isNullOrEmpty(user.getEmail())) {
                predicates.add(criteriaBuilder.equal(root.get("email"), user.getEmail()));
            }

            if (serviceCategory != null) {
                //if you have several conditions then you should create a new predicate and add the conditions to it like above then add this new predicate to where clause.
                specialistSubquery.select(specialistRoot.get("id")).where(criteriaBuilder.isMember(serviceCategory,specialistRoot.get("serviceCategoryList")));
                predicates.add(root.get("id").in(specialistSubquery));
            }

            return userCriteriaQuery.where(predicates.toArray(new Predicate[0])).getRestriction();
        };
    }
}
