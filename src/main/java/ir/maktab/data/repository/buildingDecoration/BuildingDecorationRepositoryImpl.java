package ir.maktab.data.repository.buildingDecoration;

import ir.maktab.data.entity.BuildingDecoration.BuildingDecoration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BuildingDecorationRepositoryImpl implements BuildingDecorationRepository{
    private final SessionFactory sessionFactory;

    public BuildingDecorationRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(BuildingDecoration buildingDecoration) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(buildingDecoration);
        tx.commit();
        session.close();
    }

    @Override
    public void update(BuildingDecoration buildingDecoration) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(buildingDecoration);
        tx.commit();
        session.close();

    }

    @Override
    public Optional<BuildingDecoration> get(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from ir.maktab.data.entity.BuildingDecoration as c  where c.id = :c_id")
                .setParameter("c_id",id);
        Optional f =  query.getResultList().stream().findFirst();
        transaction.commit();
        session.close();
        return f;
    }

    @Override
    public List<BuildingDecoration> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<BuildingDecoration> list =
                (List<BuildingDecoration>) session.createQuery("from ir.maktab.data.entity.BuildingDecoration.BuildingDecoration").list();
        tx.commit();
        session.close();
        return list;
    }

    @Override
    public void delete(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from ir.maktab.data.entity.BuildingDecoration.BuildingDecoration as c  where c.id = :c_id")
                .setParameter("c_id",id).executeUpdate();
        tx.commit();
        session.close();

    }
}
