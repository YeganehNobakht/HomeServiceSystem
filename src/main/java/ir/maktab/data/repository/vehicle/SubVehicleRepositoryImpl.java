package ir.maktab.data.repository.vehicle;

import ir.maktab.data.entity.BuildingDecoration.SubBuildingDecoration;
import ir.maktab.data.entity.vehicle.SubVehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SubVehicleRepositoryImpl implements SubVehicleRepository {
    private final SessionFactory sessionFactory;

    public SubVehicleRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(SubVehicle subVehicle) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(subVehicle);
        tx.commit();
        session.close();
    }

    @Override
    public void update(SubVehicle subVehicle) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(subVehicle);
        tx.commit();
        session.close();

    }

    @Override
    public Optional<SubVehicle> get(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from ir.maktab.data.entity.vehicle.SubVehicle as c  where c.id = :c_id")
                .setParameter("c_id",id);
        Optional f =  query.getResultList().stream().findFirst();
        transaction.commit();
        session.close();
        return f;
    }

    @Override
    public List<SubVehicle> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<SubVehicle> list =
                (List<SubVehicle>) session.createQuery("from ir.maktab.data.entity.vehicle.SubVehicle").list();
        tx.commit();
        session.close();
        return list;
    }

    @Override
    public void delete(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from ir.maktab.data.entity.vehicle.SubVehicle as c  where c.id = :c_id")
                .setParameter("c_id",id).executeUpdate();
        tx.commit();
        session.close();

    }
}
