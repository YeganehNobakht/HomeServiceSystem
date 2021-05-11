package ir.maktab.data.repository.cleaningAndHygiene;

import ir.maktab.data.entity.CleaningAndHygiene.SubCleaningAndHygiene;
import ir.maktab.data.entity.moving.SubMoving;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SubCleaningAndHygieneRepositoryImpl implements SubCleaningAndHygieneRepository {
    private final SessionFactory sessionFactory;

    public SubCleaningAndHygieneRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(SubCleaningAndHygiene subCleaningAndHygiene) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(subCleaningAndHygiene);
        tx.commit();
        session.close();
    }

    @Override
    public void update(SubCleaningAndHygiene subCleaningAndHygiene) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(subCleaningAndHygiene);
        tx.commit();
        session.close();

    }

    @Override
    public Optional<SubCleaningAndHygiene> get(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from ir.maktab.data.entity.CleaningAndHygiene.SubCleaningAndHygiene as c  where c.id = :c_id")
                .setParameter("c_id",id);
        Optional f =  query.getResultList().stream().findFirst();
        transaction.commit();
        session.close();
        return f;
    }

    @Override
    public List<SubCleaningAndHygiene> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<SubCleaningAndHygiene> list =
                (List<SubCleaningAndHygiene>) session.createQuery("from ir.maktab.data.entity.CleaningAndHygiene.SubCleaningAndHygiene").list();
        tx.commit();
        session.close();
        return list;
    }

    @Override
    public void delete(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from ir.maktab.data.entity.CleaningAndHygiene.SubCleaningAndHygiene as c  where c.id = :c_id")
                .setParameter("c_id",id).executeUpdate();
        tx.commit();
        session.close();

    }
}
