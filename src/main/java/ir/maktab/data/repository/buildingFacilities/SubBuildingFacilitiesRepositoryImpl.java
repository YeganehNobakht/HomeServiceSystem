package ir.maktab.data.repository.buildingFacilities;

import ir.maktab.data.entity.BuildingFacilities.SubBuildingFacilities;
import ir.maktab.data.entity.moving.SubMoving;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SubBuildingFacilitiesRepositoryImpl implements SubBuildingFacilitiesRepository {
    private final SessionFactory sessionFactory;

    public SubBuildingFacilitiesRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(SubBuildingFacilities subBuildingFacilities) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(subBuildingFacilities);
        tx.commit();
        session.close();
    }

    @Override
    public void update(SubBuildingFacilities subBuildingFacilities) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(subBuildingFacilities);
        tx.commit();
        session.close();

    }

    @Override
    public Optional<SubBuildingFacilities> get(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from ir.maktab.data.entity.BuildingFacilities.SubBuildingFacilities as c  where c.id = :c_id")
                .setParameter("c_id",id);
        Optional f =  query.getResultList().stream().findFirst();
        transaction.commit();
        session.close();
        return f;
    }

    @Override
    public List<SubBuildingFacilities> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<SubBuildingFacilities> list =
                (List<SubBuildingFacilities>) session.createQuery("from ir.maktab.data.entity.BuildingFacilities.SubBuildingFacilities").list();
        tx.commit();
        session.close();
        return list;
    }

    @Override
    public void delete(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from ir.maktab.data.entity.BuildingFacilities.SubBuildingFacilities as c  where c.id = :c_id")
                .setParameter("c_id",id).executeUpdate();
        tx.commit();
        session.close();

    }
}
