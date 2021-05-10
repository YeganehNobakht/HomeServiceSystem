package ir.maktab.data.repository.BuildingDecoration;

import ir.maktab.data.entity.BuildingDecoration.BuildingDecoration;
import ir.maktab.data.entity.BuildingDecoration.SubBuildingDecoration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class SubBuildingDecorationRepositoryImpl implements SubBuildingDecorationRepository {
    private final SessionFactory sessionFactory;

    public SubBuildingDecorationRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(SubBuildingDecoration buildingDecoration) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(buildingDecoration);
        tx.commit();
        session.close();
    }

    @Override
    public void update(SubBuildingDecoration buildingDecoration) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(buildingDecoration);
        tx.commit();
        session.close();

    }

    @Override
    public Optional<SubBuildingDecoration> get(Integer id) {
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
    public List<SubBuildingDecoration> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<SubBuildingDecoration> list =
                (List<SubBuildingDecoration>) session.createQuery("from ir.maktab.data.entity.BuildingDecoration").list();
        tx.commit();
        session.close();
        return list;
    }

    @Override
    public void delete(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from ir.maktab.data.entity.BuildingDecoration as c  where c.id = :c_id")
                .setParameter("c_id",id).executeUpdate();
        tx.commit();
        session.close();

    }
}
