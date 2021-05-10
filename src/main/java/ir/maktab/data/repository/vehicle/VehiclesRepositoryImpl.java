package ir.maktab.data.repository.vehicle;

import ir.maktab.data.entity.vehicle.Vehicles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class VehiclesRepositoryImpl implements VehiclesRepository {
    private final SessionFactory sessionFactory;

    public VehiclesRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Vehicles vehicles) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(vehicles);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Vehicles vehicles) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(vehicles);
        tx.commit();
        session.close();

    }

    @Override
    public Optional<Vehicles> get(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from ir.maktab.data.entity.vehicle.Vehicles as c  where c.id = :c_id")
                .setParameter("c_id",id);
        Optional f =  query.getResultList().stream().findFirst();
        transaction.commit();
        session.close();
        return f;
    }

    @Override
    public List<Vehicles> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Vehicles> list =
                (List<Vehicles>) session.createQuery("from ir.maktab.data.entity.vehicle.Vehicles").list();
        tx.commit();
        session.close();
        return list;
    }

    @Override
    public void delete(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from ir.maktab.data.entity.vehicle.Vehicles as c  where c.id = :c_id")
                .setParameter("c_id",id).executeUpdate();
        tx.commit();
        session.close();

    }
}
