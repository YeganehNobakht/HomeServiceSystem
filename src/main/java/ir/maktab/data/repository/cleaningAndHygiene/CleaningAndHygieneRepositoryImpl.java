package ir.maktab.data.repository.cleaningAndHygiene;

import ir.maktab.data.entity.CleaningAndHygiene.CleaningAndHygiene;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class CleaningAndHygieneRepositoryImpl implements CleaningAndHygieneRepository {
    private final SessionFactory sessionFactory;

    public CleaningAndHygieneRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(CleaningAndHygiene cleaningAndHygiene) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(cleaningAndHygiene);
        tx.commit();
        session.close();
    }

    @Override
    public void update(CleaningAndHygiene cleaningAndHygiene) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(cleaningAndHygiene);
        tx.commit();
        session.close();

    }

    @Override
    public Optional<CleaningAndHygiene> get(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from ir.maktab.data.entity.CleaningAndHygiene.CleaningAndHygiene as c  where c.id = :c_id")
                .setParameter("c_id",id);
        Optional f =  query.getResultList().stream().findFirst();
        transaction.commit();
        session.close();
        return f;
    }

    @Override
    public List<CleaningAndHygiene> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<CleaningAndHygiene> list =
                (List<CleaningAndHygiene>) session.createQuery("from ir.maktab.data.entity.CleaningAndHygiene.CleaningAndHygiene").list();
        tx.commit();
        session.close();
        return list;
    }

    @Override
    public void delete(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from ir.maktab.data.entity.CleaningAndHygiene.CleaningAndHygiene as c  where c.id = :c_id")
                .setParameter("c_id",id).executeUpdate();
        tx.commit();
        session.close();

    }
}
