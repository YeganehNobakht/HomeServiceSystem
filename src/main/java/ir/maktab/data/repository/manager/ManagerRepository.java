package ir.maktab.data.repository.manager;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerRepository {
    void create(Manager manager);
    void update(Manager manager);
    Optional<Manager> get(Integer id);
    List<Manager> getAll();
    void delete(Integer integer);
}
