package ir.maktab.data.repository.suggestion;

import ir.maktab.data.entity.CustomerOrder;
import ir.maktab.data.entity.Specialist;
import ir.maktab.data.entity.Suggestion;
import ir.maktab.data.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

@Repository
public interface SuggestionRepository extends JpaRepository , JpaSpecificationExecutor<Suggestion> {


    static Specification<Suggestion> filterSuggestion(Suggestion suggestion){
        return (Specification<Suggestion>) (root, cq, cb) -> {
            ArrayList<Predicate> predicates = new ArrayList<>();

            Join<Suggestion, CustomerOrder> order = root.join("customerOrder");
            Join<Suggestion, Specialist> specialist = root.join("specialist");



//             cq.orderBy(cb.desc(root.get("price")),);
//             cq.orderBy(cb.desc(specialist.get("rate")));

            cq.orderBy(cb.desc(root.get("price")),cb.desc(specialist.get("rate")));

            return cq.where(predicates.toArray(new Predicate[0])).getRestriction();
        };
    }
}
