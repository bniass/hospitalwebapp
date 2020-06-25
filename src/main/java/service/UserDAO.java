package service;

import model.Utilisateur;
import org.hibernate.Session;
import utils.HibernateUtil;

import javax.ejb.Stateless;

@Stateless
public class UserDAO implements IUser {
    Session session;
    public UserDAO(){
        session = HibernateUtil.getSession();
    }
    @Override
    public Utilisateur authentification(String login, String pwd) {

        try {
            return session.createQuery("SELECT u FROM Utilisateur u WHERE u.login = :log AND u.pwd = :pass", Utilisateur.class)
                    .setParameter("log",login)
                    .setParameter("pass", pwd)
                    .getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
