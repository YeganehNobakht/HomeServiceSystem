package ir.maktab.data.repository.Customer;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.moving.Moving;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {


    private final SessionFactory sessionFactory;

    public CustomerRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Customer customer) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(customer);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Customer customer) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(customer);
        tx.commit();
        session.close();

    }

    @Override
    public Optional<Customer> get(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from ir.maktab.data.entity.Customer as c  where c.username = :c_id")
                .setParameter("c_id",id);
        Optional f =  query.getResultList().stream().findFirst();
        transaction.commit();
        session.close();
        return f;
    }

    @Override
    public List<Customer> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Customer> list =
                (List<Customer>) session.createQuery("from ir.maktab.data.entity.Customer").list();
        tx.commit();
        session.close();
        return list;
    }

    @Override
    public void delete(String id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from ir.maktab.data.entity.Customer as c  where c.uesrname = :c_id")
                .setParameter("c_id",id).executeUpdate();
        tx.commit();
        session.close();

    }
}
