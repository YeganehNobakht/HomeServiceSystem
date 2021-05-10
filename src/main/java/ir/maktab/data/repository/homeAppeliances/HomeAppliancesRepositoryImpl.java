package ir.maktab.data.repository.homeAppeliances;

import ir.maktab.data.entity.homeAppliances.HomeAppliances;
import ir.maktab.data.entity.moving.Moving;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class HomeAppliancesRepositoryImpl implements HomeAppliancesRepository {
    private final SessionFactory sessionFactory;

    public HomeAppliancesRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(HomeAppliances homeAppliances) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(homeAppliances);
        tx.commit();
        session.close();
    }

    @Override
    public void update(HomeAppliances homeAppliances) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(homeAppliances);
        tx.commit();
        session.close();

    }

    @Override
    public Optional<HomeAppliances> get(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from ir.maktab.data.entity.homeAppliances.HomeAppliances as c  where c.id = :c_id")
                .setParameter("c_id",id);
        Optional f =  query.getResultList().stream().findFirst();
        transaction.commit();
        session.close();
        return f;
    }

    @Override
    public List<HomeAppliances> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<HomeAppliances> list =
                (List<HomeAppliances>) session.createQuery("from ir.maktab.data.entity.homeAppliances.HomeAppliances").list();
        tx.commit();
        session.close();
        return list;
    }

    @Override
    public void delete(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from ir.maktab.data.entity.homeAppliances.HomeAppliances as c  where c.id = :c_id")
                .setParameter("c_id",id).executeUpdate();
        tx.commit();
        session.close();

    }
}
