package service;

import model.Service;
import model.Specialite;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ParametreDAO implements IParametre{
    Session session;
    public ParametreDAO(){
        session = HibernateUtil.getSession();
    }
    @Override
    public List<Specialite> findSpecialites() {
        return session.createQuery("SELECT sp FROM Specialite sp",
                Specialite.class).list();
    }

    @Override
    public List<Service> findServices() {
        return session.createQuery("SELECT srv FROM Service srv",
                Service.class).list();
    }

    @Override
    public Specialite addSpecialite(Specialite specialite) {
        try {
            session.save(specialite);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return specialite;
    }

    @Override
    public Service findServiceById(long id) {
        return session.find(Service.class, id);
    }

    @Override
    public Specialite findSpecialiteById(long id) {
        return session.find(Specialite.class, id);
    }

    @Override
    public void deleteSpecialiteById(long id) {
        Transaction t = session.getTransaction();
        try {
            Specialite sp = session.find(Specialite.class, id);
            t.begin();
            session.delete(sp);
            t.commit();
        }
        catch (Exception e){
            t.rollback();
            e.printStackTrace();
        }

    }
}
