package ir.maktab.data.repository.homeAppeliances;

import ir.maktab.data.entity.homeAppliances.HomeAppliances;
import ir.maktab.data.entity.moving.Moving;

import java.util.List;
import java.util.Optional;

public interface HomeAppliancesRepository {
    void create(HomeAppliances homeAppliances);
    void update(HomeAppliances homeAppliances);
    Optional<HomeAppliances> get(Integer id);
    List<HomeAppliances> getAll();
    void delete(Integer integer);
}
