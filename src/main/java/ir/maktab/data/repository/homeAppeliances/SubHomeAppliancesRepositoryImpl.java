package ir.maktab.data.repository.homeAppeliances;

import ir.maktab.data.entity.homeAppliances.SubHomeAppliances;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SubHomeAppliancesRepositoryImpl implements SubHomeAppliancesRepository {
    private final SessionFactory sessionFactory;

    public SubHomeAppliancesRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(SubHomeAppliances subHomeAppliances) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(subHomeAppliances);
        tx.commit();
        session.close();
    }

    @Override
    public void update(SubHomeAppliances subHomeAppliances) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(subHomeAppliances);
        tx.commit();
        session.close();

    }

    @Override
    public Optional<SubHomeAppliances> get(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from ir.maktab.data.entity.homeAppliances.SubHomeAppliances as c  where c.id = :c_id")
                .setParameter("c_id",id);
        Optional f =  query.getResultList().stream().findFirst();
        transaction.commit();
        session.close();
        return f;
    }

    @Override
    public List<SubHomeAppliances> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<SubHomeAppliances> list =
                (List<SubHomeAppliances>) session.createQuery("from ir.maktab.data.entity.homeAppliances.SubHomeAppliances").list();
        tx.commit();
        session.close();
        return list;
    }

    @Override
    public void delete(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from ir.maktab.data.entity.homeAppliances.SubHomeAppliances as c  where c.id = :c_id")
                .setParameter("c_id",id).executeUpdate();
        tx.commit();
        session.close();

    }
}
