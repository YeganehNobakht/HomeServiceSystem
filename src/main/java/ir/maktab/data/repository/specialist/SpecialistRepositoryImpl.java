package ir.maktab.data.repository.specialist;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.Specialist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class SpecialistRepositoryImpl implements SpecialistRepository {


    private final SessionFactory sessionFactory;

    public SpecialistRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Specialist specialist) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(specialist);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Specialist specialist) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(specialist);
        tx.commit();
        session.close();

    }

    @Override
    public Optional<Specialist> get(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from ir.maktab.data.entity.Specialist as c  where c.uername = :c_id")
                .setParameter("c_id",id);
        Optional f =  query.getResultList().stream().findFirst();
        transaction.commit();
        session.close();
        return f;
    }

    @Override
    public List<Specialist> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Specialist> list =
                (List<Specialist>) session.createQuery("from ir.maktab.data.entity.Specialist").list();
        tx.commit();
        session.close();
        return list;
    }

    @Override
    public void delete(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from ir.maktab.data.entity.Specialist as c  where c.username = :c_id")
                .setParameter("c_id",id).executeUpdate();
        tx.commit();
        session.close();

    }
}
