package ir.maktab.data.repository.homeAppeliances;

import ir.maktab.data.entity.homeAppliances.SubHomeAppliances;
import ir.maktab.data.entity.moving.SubMoving;

import java.util.List;
import java.util.Optional;


public interface SubHomeAppliancesRepository {
    void create(SubHomeAppliances subHomeAppliances);
    void update(SubHomeAppliances subHomeAppliances);
    Optional<SubHomeAppliances> get(Integer id);
    List<SubHomeAppliances> getAll();
    void delete(Integer integer);
}
