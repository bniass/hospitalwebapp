package service;

import model.Service;
import model.Specialite;
import org.hibernate.Session;
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
}
